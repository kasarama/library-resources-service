package cph.sysint.libraryservice.service;

import cph.sysint.libraryservice.model.Title;
import cph.sysint.libraryservice.repository.TitleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class TitleService implements ITitleService{
    @Autowired
    TitleRepository titleRepository;


    @Override
    public List<Title> getByCategory(String category) {
        return null;
    }

    @Override
    public List<Title> getByYear(int year) {
        return null;
    }

    @Override
    public List<Title> getByPublisher(String publisher) {
        return null;
    }

    @Override
    public List<Title> getByTitle(String title) {
        return null;
    }

    @Override
    public List<Title> getByPriceRange(double min, double max) {
        return null;
    }

    @Override
    public Title getById(int id) {
        return titleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Title with id "+ id+ " not found"));
    }
}
