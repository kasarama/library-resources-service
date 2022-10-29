package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Category;
import cph.sysint.libraryservice.model.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TitleDTO extends RepresentationModel {
    private Integer id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String publisher;
    private int edition;
    private int year;
    private double price;
    private Set<String> categories = new HashSet<>();

    public TitleDTO(Title entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.authorFirstName = entity.getAuthor().getFirstName();
        this.authorLastName = entity.getAuthor().getLastName();
        this.publisher = entity.getPublisher().getPublisherName();
        this.edition = entity.getEdition();
        this.year = entity.getYear();
        this.price = entity.getPrice();
        for (Category c : entity.getCategory()
        ) {
            this.categories.add(c.getCategoryName());
        }
    }
}
