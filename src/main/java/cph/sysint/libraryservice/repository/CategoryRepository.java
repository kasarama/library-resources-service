package cph.sysint.libraryservice.repository;

import cph.sysint.libraryservice.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
    Category findCategoryByCategoryName(String category);

}
