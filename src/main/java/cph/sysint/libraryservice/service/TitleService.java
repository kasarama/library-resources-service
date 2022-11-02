package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.exeption.NotFoundException;
import cph.sysint.libraryservice.dto.*;
import cph.sysint.libraryservice.model.Category;
import cph.sysint.libraryservice.model.Publisher;
import cph.sysint.libraryservice.model.Title;
import cph.sysint.libraryservice.repository.CategoryRepository;
import cph.sysint.libraryservice.repository.PublisherRepository;
import cph.sysint.libraryservice.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TitleService implements ITitleService {
    @Autowired
    TitleRepository titleRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PublisherRepository publisherRepository;


    @Override
    public GetTitleListResponse getByCategory(String category, Pageable pageable) {
        try {
            Category c = categoryRepository.findCategoryByCategoryName(category);
            Page page = titleRepository.findAllByCategoryIs(c, pageable);
            return new GetTitleListResponse(page.getNumber(), page.getTotalElements(), page.getTotalPages(), page.getContent());
        } catch (Exception ex) {
            throw new NotFoundException("No category with the given name: " + category);
        }
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
        return new TitleDTO(titleRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("Title with id " + id + " not found")));
    }

    @Override
    public GetCategoriesListResponse getAllCategories(Pageable pageable) {
        Page<Category> page = categoryRepository.findAll(pageable);
        GetCategoriesListResponse response = new GetCategoriesListResponse(
                page.getNumber(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent());
        return response;
    }

    @Override
    public GetPublishersListResponse getAllPublishers(Pageable pageable) {
        List<PublisherDTO> publisherDTOS = new ArrayList<>();
        Page<Publisher> page = publisherRepository.findAll(pageable);
        GetPublishersListResponse response = new GetPublishersListResponse(
                page.getNumber(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.getContent());
        return response;
    }

}
