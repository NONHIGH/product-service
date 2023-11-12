package nonhigh.products.repository;

import java.util.List;
import nonhigh.products.entity.Category;
import nonhigh.products.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    public List<Product> findByCategory(Category category);
}
