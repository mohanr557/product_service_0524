package in.mohan.product_service_0524.repositories;

import in.mohan.product_service_0524.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);
    Category findByTitle(String name);
    List<Category> findByTitleEndingWith(String ending);
}
