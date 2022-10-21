package cph.sysint.libraryservice.repository;

import cph.sysint.libraryservice.model.Category;
import cph.sysint.libraryservice.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends PagingAndSortingRepository<Title, Integer> {

   Page<Title> findAllByCategoryIs(Category category, Pageable pageable);
    List<Title> findAllByPriceBetween(double min, double max);
}
