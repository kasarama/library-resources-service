package cph.sysint.libraryservice.control;

import cph.sysint.libraryservice.model.Title;
import cph.sysint.libraryservice.service.ITitleService;
import cph.sysint.libraryservice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping(value = "/titles", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TitleController {

    private ITitleService titleService;

    @Autowired
    TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Title>> getTitleById(@PathVariable int id) {
        Link link = linkTo(TitleController.class).slash(id).withSelfRel();
        List<Link> links = new ArrayList<>();
        links.add(link);
        Title title = titleService.getById(id);

        title.getCategory().forEach(category -> {
            Link linkC = linkTo(TitleController.class).slash(category.getCategoryName()).withRel("titles in the same category");
            links.add(linkC);
        });
        EntityModel<Title> titleResource = EntityModel.of(title, links);

        return new ResponseEntity<>(titleResource, HttpStatus.OK);
    }


    @GetMapping("category/{category}")
    public ResponseEntity<Map<String, Object>> getTitlesByCategoryName(@PathVariable String category, @RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "5") int size) {


        Pageable pageable = PageRequest.of(page, size);
        Page<Title> currentPage = titleService.getByCategory(category, pageable);
        List<Title> titles = currentPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("titles", titles);
        response.put("currentPage", currentPage.getNumber());
        response.put("totalItems", currentPage.getTotalElements());
        response.put("totalPages", currentPage.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("publisher/{publisher}")
    public ResponseEntity<Map<String, Object>> getTitlesByPublisherName(@PathVariable String publisher, @RequestParam(defaultValue = "0") int page,
                                                                        @RequestParam(defaultValue = "5") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Title> currentPage = titleService.getByPublisher(publisher, pageable);
        List<Title> titles = currentPage.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("titles", titles);
        response.put("currentPage", currentPage.getNumber());
        response.put("totalItems", currentPage.getTotalElements());
        response.put("totalPages", currentPage.getTotalPages());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
