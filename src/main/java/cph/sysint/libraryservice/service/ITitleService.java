package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.exeption.NotFoundException;
import cph.sysint.libraryservice.dto.*;
import org.springframework.data.domain.Pageable;

public interface ITitleService {
    int decreaseQuantity(int id) throws NotFoundException;

    GetTitleListResponse getByCategory(String category, Pageable pageable);

    GetTitleListResponse getByYear(int year, Pageable pageable);

    GetTitleListResponse getByPublisher(String publisher, Pageable pageable);

    GetTitleListResponse getByTitle(String title, Pageable pageable);

    GetTitleListResponse getByPriceRange(double min, double max, Pageable pageable);

    TitleDTO getById(int id);

    GetCategoriesListResponse getAllCategories(Pageable pageable);

    GetPublishersListResponse getAllPublishers(Pageable pageable);

}
