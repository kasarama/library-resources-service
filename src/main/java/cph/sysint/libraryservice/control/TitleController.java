package cph.sysint.libraryservice.control;

import cph.sysint.libraryservice.dto.*;
import cph.sysint.libraryservice.service.ITitleService;
import cph.sysint.libraryservice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<TitleDTO> getTitleById(@PathVariable int id) {
        TitleDTO titleDTO = titleService.getById(id);
        addLinksToTitle(titleDTO);
        return new ResponseEntity<>(titleDTO, HttpStatus.OK);
    }

    @GetMapping("category/{category}")
    public ResponseEntity<GetTitleListResponse> getTitlesByCategory(@PathVariable String category, @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        GetTitleListResponse response = titleService.getByCategory(category, pageable);
        response.getTitles().forEach(titleDTO -> addLinksToTitle(titleDTO));
        response.add(linkTo(TitleController.class).slash("category").slash(category).withSelfRel());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("publisher/{publisher}")
    public ResponseEntity<GetTitleListResponse> getTitlesByPublisher(@PathVariable String publisher, @RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        GetTitleListResponse response = titleService.getByPublisher(publisher, pageable);
        response.getTitles().forEach(titleDTO -> titleDTO.add(linkTo(TitleController.class).slash(titleDTO.getId()).withSelfRel()));
        response.add(linkTo(TitleController.class).slash("publisher").slash(publisher).withSelfRel());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("publisher")
    public ResponseEntity<GetPublishersListResponse> getAllPublishers(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        GetPublishersListResponse response = titleService.getAllPublishers(pageable);

        for (PublisherDTO publisherDTO : response.getPublishers()) {
            publisherDTO.add(linkTo(TitleController.class).slash("publisher").slash(publisherDTO.getPublisher()).withSelfRel());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<GetCategoriesListResponse> getAllCategories(@RequestParam(defaultValue = "0") int page,
                                                                      @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        GetCategoriesListResponse response = titleService.getAllCategories(pageable);

        for (CategoryDTO category : response.getCategories()) {
            category.add(linkTo(TitleController.class).slash("category").slash(category.getCategory()).withSelfRel());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void addLinksToTitle(TitleDTO titleDTO) {
        titleDTO.add(linkTo(TitleController.class).slash(titleDTO.getId()).withSelfRel());

        for (CategoryDTO category : titleDTO.getCategories()) {
            category.add(linkTo(TitleController.class).slash("category").slash(category.getCategory()).withSelfRel());
        }
        titleDTO.getPublisher().add(linkTo(TitleController.class).slash("publisher").slash(titleDTO.getPublisher().getPublisher()).withSelfRel());
        titleDTO.add(linkTo(TitleController.class).slash("publisher").withRel("allPublishers"));
        titleDTO.add(linkTo(TitleController.class).slash("category").withRel("allCategories"));
    }

}
