package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.control.exeption.NotFoundException;
import cph.sysint.libraryservice.dto.GetTitleListResponse;
import cph.sysint.libraryservice.dto.TitleDTO;
import cph.sysint.libraryservice.model.Category;
import cph.sysint.libraryservice.model.Title;
import cph.sysint.libraryservice.repository.CategoryRepository;
import cph.sysint.libraryservice.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TitleService implements ITitleService {
    @Autowired
    TitleRepository titleRepository;
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public GetTitleListResponse getByCategory(String category, Pageable pageable) {
        Category c = categoryRepository.findCategoryByCategoryName(category);
        // TODO handle not found exception
        Page page = titleRepository.findAllByCategoryIs(c, pageable);
        GetTitleListResponse response = new GetTitleListResponse(page.getNumber(), page.getTotalElements(), page.getTotalPages(), page.getContent());
        return response;
    }

    @Override
    public GetTitleListResponse getByYear(int year, Pageable pageable) {
        return null;
    }

    @Override
    public GetTitleListResponse getByPublisher(String publisher, Pageable pageable) {
        Page<Title> page = titleRepository.findAllByPublisherName(publisher, pageable);
        GetTitleListResponse response = new GetTitleListResponse(page.getNumber(), page.getTotalElements(), page.getTotalPages(), page.getContent());
        return response;

    }

    @Override
    public GetTitleListResponse getByTitle(String title, Pageable pageable) {
        return null;
    }

    @Override
    public GetTitleListResponse getByPriceRange(double min, double max, Pageable pageable) {
        return null;
    }


    @Override
    public int decreaseQuantity(int id) throws NotFoundException {
        return titleRepository.decreaseQuantity(id);
    }

    public TitleDTO getById(int id) {
        return new TitleDTO(titleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Title with id " + id + " not found")));
    }

}
