package softuni.pathfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.pathfinder.model.entity.CategoryEntity;
import softuni.pathfinder.model.entity.enums.Category;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {


    CategoryEntity findByName(String name);

    Set<CategoryEntity> findByNameIn(Set<Category> categories);
}
