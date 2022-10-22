package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITitleService {

    Page<Title> getByCategory(String category, Pageable pageable);
    List<Title> getByYear(int year, Pageable pageable);
    Page<Title> getByPublisher(String publisher, Pageable pageable);
    List<Title> getByTitle(String title, Pageable pageable);
    List<Title> getByPriceRange(double min, double max, Pageable pageable);

    Title getById(int id);
}
