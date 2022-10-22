package cph.sysint.libraryservice.repository;

import cph.sysint.libraryservice.model.Category;
import cph.sysint.libraryservice.model.Title;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends PagingAndSortingRepository<Title, Integer> {

    Page<Title> findAllByCategoryIs(Category category, Pageable pageable);

    @Query("SELECT t FROM Title t  WHERE t.publisher.publisherName = ?1")
    Page<Title> findAllByPublisherName(String publisher, Pageable pageable);
}
