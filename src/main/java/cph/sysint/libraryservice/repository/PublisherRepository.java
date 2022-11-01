package cph.sysint.libraryservice.repository;

import cph.sysint.libraryservice.model.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends PagingAndSortingRepository<Publisher, Integer> {
    Publisher findPublisherByPublisherName(String publisher);

    Page<Publisher> findAll(Pageable pageable);

}