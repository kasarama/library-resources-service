package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.control.exeption.NotFoundException;
import cph.sysint.libraryservice.model.Category;
import cph.sysint.libraryservice.model.Title;
import cph.sysint.libraryservice.repository.CategoryRepository;
import cph.sysint.libraryservice.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TitleService implements ITitleService {
    @Autowired
    TitleRepository titleRepository;
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Page<Title> getByCategory(String category, Pageable pageable) {
        Category c = categoryRepository.findCategoryByCategoryName(category);
        return titleRepository.findAllByCategoryIs(c, pageable);
    }

    @Override
    public List<Title> getByYear(int year, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Title> getByPublisher(String publisher, Pageable pageable) {
        return titleRepository.findAllByPublisherName(publisher, pageable);
    }

    @Override
    public List<Title> getByTitle(String title, Pageable pageable) {
        return null;
    }

    @Override
    public List<Title> getByPriceRange(double min, double max, Pageable pageable) {
        return null;
    }

    @Override
    public Title getById(int id) {
        return titleRepository.findById(id).orElseThrow(() -> new NotFoundException("Title with id " + id + " not found"));
    }

    @Override
    public int decreaseQuantity(int id) throws NotFoundException {
        return titleRepository.decreaseQuantity(id);
    }
}
