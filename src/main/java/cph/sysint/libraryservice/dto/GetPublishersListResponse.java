package cph.sysint.libraryservice.dto;

import cph.sysint.libraryservice.model.Publisher;
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
public class GetPublishersListResponse extends RepresentationModel {

    private List<PublisherDTO> publishers;
    private int currentPage;
    private long totalTitles;
    private int totalPages;

    public GetPublishersListResponse(int currentPage, long totalTitles, int totalPages, List<Publisher> entities) {
        this.publishers = new ArrayList<>();
        entities.forEach(e -> {
            this.publishers.add(new PublisherDTO(e));
        });
        this.currentPage = currentPage;
        this.totalTitles = totalTitles;
        this.totalPages = totalPages;
    }
}