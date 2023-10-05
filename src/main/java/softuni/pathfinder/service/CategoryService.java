package softuni.pathfinder.service;

import org.springframework.stereotype.Service;
import softuni.pathfinder.model.entity.CategoryEntity;
import softuni.pathfinder.model.entity.enums.Category;
import softuni.pathfinder.repository.CategoryRepository;

import java.util.Set;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;
    }


}
