package cph.sysint.libraryservice.repository;

import cph.sysint.libraryservice.model.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends CrudRepository<Title, Integer> {
}
