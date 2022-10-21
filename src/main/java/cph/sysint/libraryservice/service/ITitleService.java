package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.model.Title;

import java.util.List;

public interface ITitleService {

    List<Title> getByCategory(String category);
    List<Title> getByYear(int year);
    List<Title> getByPublisher(String publisher);
    List<Title> getByTitle(String title);
    List<Title> getByPriceRange(double min, double max);

    Title getById(int id);
}
