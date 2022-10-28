package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Category;
import cph.sysint.libraryservice.model.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TitleDTO {
    private Integer id;
    private String title;
    private int edition;
    private int year;
    private double price;
    private Set<String> categories;

    public TitleDTO(Title entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.edition = entity.getEdition();
        this.year = entity.getYear();
        this.price = entity.getPrice();
        for (Category c : entity.getCategory()
        ) {
            this.categories.add(c.getCategoryName());

        }


    }
}
