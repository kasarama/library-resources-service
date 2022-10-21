package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITitleService {

    Page<Title> getByCategory(String category, Pageable pageable);
    List<Title> getByYear(int year);
    List<Title> getByPublisher(String publisher);
    List<Title> getByTitle(String title);
    List<Title> getByPriceRange(double min, double max);

    Title getById(int id);
}
