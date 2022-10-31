package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoriesListResponse extends RepresentationModel {

    private List<CategoryDTO> categories;
    private int currentPage;
    private long totalTitles;
    private int totalPages;

    public GetCategoriesListResponse(int currentPage, long totalTitles, int totalPages, List<Category> entities) {
        this.categories = new ArrayList<>();
        entities.forEach(e -> {

            this.categories.add(new CategoryDTO(e));
        });
        this.currentPage = currentPage;
        this.totalTitles = totalTitles;
        this.totalPages = totalPages;
    }


}
