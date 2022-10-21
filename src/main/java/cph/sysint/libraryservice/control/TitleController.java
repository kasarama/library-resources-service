package cph.sysint.libraryservice.control;

import cph.sysint.libraryservice.model.Title;
import cph.sysint.libraryservice.service.ITitleService;
import cph.sysint.libraryservice.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        Title title = titleService.getById(id);
        EntityModel<Title> titleResource = EntityModel.of(title, link);

        return new ResponseEntity<>(titleResource, HttpStatus.OK);
    }
}
