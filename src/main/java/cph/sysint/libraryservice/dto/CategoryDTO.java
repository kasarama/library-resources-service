package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO extends RepresentationModel {
    private String category;

    public CategoryDTO(Category entity) {
        this.category = entity.getCategoryName();
    }
}
