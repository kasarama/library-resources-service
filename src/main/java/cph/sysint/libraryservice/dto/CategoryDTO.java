package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private String category;

    public CategoryDTO(Category entity) {
        this.category = entity.getCategoryName();
    }
}
