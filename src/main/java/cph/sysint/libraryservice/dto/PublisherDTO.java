package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDTO extends RepresentationModel {
    private String publisher;

    public PublisherDTO(Publisher entity) {
        this.publisher = entity.getPublisherName();
    }
}
