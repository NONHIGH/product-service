package nonhigh.products.service;

import nonhigh.products.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public ResponseEntity<List<Category>> findCategories();

    public ResponseEntity<Category> createCategory(Category category);

    public ResponseEntity<Category> findCategoryById(Long id);

    public ResponseEntity<Category> editCategory(Category category, Long id);

    public ResponseEntity<?> deleteCategory(Long id);


}
