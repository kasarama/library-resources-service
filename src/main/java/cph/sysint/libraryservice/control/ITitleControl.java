package cph.sysint.libraryservice.control;

import cph.sysint.libraryservice.dto.GetTitleListResponse;
import cph.sysint.libraryservice.dto.TitleDTO;
import cph.sysint.libraryservice.model.Title;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

public interface ITitleControl {
    ResponseEntity<GetTitleListResponse> getTitlesByPublisher(String publisher, int page, int size);
    ResponseEntity<GetTitleListResponse> getTitlesByCategory(String publisher, int page, int size);

    ResponseEntity<EntityModel<Title>>getTitleById(int id);


}
