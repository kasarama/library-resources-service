package cph.sysint.libraryservice.service;

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

import java.util.ArrayList;
import java.util.Collection;
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
    public GetTitleListResponse getByCategory(String category, Pageable pageable) {
        Category c = categoryRepository.findCategoryByCategoryName(category);
        // TODO handle not found exception

        return titleRepository.findAllByCategoryIs(c, pageable);
    }

    @Override
    public GetTitleListResponse getByYear(int year, Pageable pageable) {
        return null;
    }

    @Override
    public GetTitleListResponse getByPublisher(String publisher, Pageable pageable) {

        Page<Title> entities = titleRepository.findAllByPublisherName(publisher, pageable);

        List<Title> titles = entities.getContent();
        List<TitleDTO> dtos = new ArrayList<>();
        entityToDtoMapper(titles, dtos);
        return dtos;

    }


    @Override
    public TitleDTO getById(int id) {
        return new TitleDTO(titleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Title with id " + id + " not found")));
    }
// Implement response object that will have the attributes that the map below has and return it from the service

    void entityToDtoMapper(Collection<Title> ents, Collection<TitleDTO> dtos) {
        ents.forEach(e -> {
            dtos.add(new TitleDTO(e));
        });

    }


}
