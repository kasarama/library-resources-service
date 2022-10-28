package cph.sysint.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetTitleListResponse {
    private List<TitleDTO> titles;
    private int currentPage;
    private int totalTitles;
    private int totalPages;



}
