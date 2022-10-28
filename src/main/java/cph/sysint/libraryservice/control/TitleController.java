package cph.sysint.libraryservice.control;

import cph.sysint.libraryservice.dto.GetTitleListResponse;
import cph.sysint.libraryservice.dto.TitleDTO;
import cph.sysint.libraryservice.service.ITitleService;
import cph.sysint.libraryservice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;


@RestController
@RequestMapping(value = "/titles", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TitleController implements ITitleControl {

    private ITitleService titleService;

    @Autowired
    TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<TitleDTO>> getTitleById(@PathVariable int id) {
        Link link = linkTo(TitleController.class).slash(id).withSelfRel();
        List<Link> links = new ArrayList<>();
        links.add(link);
        TitleDTO title = titleService.getById(id);

        title.getCategories().forEach(category -> {
            Link linkC = linkTo(TitleController.class).slash(category).withRel("titles in the same category");
            links.add(linkC);
        });
        EntityModel<TitleDTO> titleResource = EntityModel.of(title, links);

        return new ResponseEntity<>(titleResource, HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<GetTitleListResponse> getTitlesByCategory(@PathVariable String category, @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        GetTitleListResponse response = titleService.getByCategory(category, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("publisher/{publisher}")
    public ResponseEntity<GetTitleListResponse> getTitlesByPublisher(@PathVariable String publisher, @RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        GetTitleListResponse response = titleService.getByPublisher(publisher, pageable);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
