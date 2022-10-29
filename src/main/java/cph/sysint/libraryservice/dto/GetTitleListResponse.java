package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Title;
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
public class GetTitleListResponse extends RepresentationModel {
    private List<TitleDTO> titles = new ArrayList<>();
    private int currentPage;
    private long totalTitles;
    private int totalPages;

    public GetTitleListResponse(int currentPage, long totalTitles, int totalPages, List<Title> entities) {
        entities.forEach(e -> {
            this.titles.add(new TitleDTO(e));
        });
        this.currentPage = currentPage;
        this.totalTitles = totalTitles;
        this.totalPages = totalPages;
    }

    public void setTitles(List<Title> entities) {
        entities.forEach(e -> {
            this.titles.add(new TitleDTO(e));
        });
    }
}
