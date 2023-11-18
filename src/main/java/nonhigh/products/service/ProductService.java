package nonhigh.products.service;

import nonhigh.products.dto.ProductPost;
import nonhigh.products.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    public ResponseEntity<List<Product>> findProducts();

    public ResponseEntity<Product> findProductById(Long id);

    public ResponseEntity<Product> createProduct(ProductPost product);

    public ResponseEntity<?> deleteProduct(Long id);

    public ResponseEntity<Product> editProduct(Product product, Long idProduct);

    public ResponseEntity<Product> editStockProduct(Long id, Double stock);

    public ResponseEntity<List<Product>> findProductsByCategory(String name);
    public ResponseEntity<List<Product>> findProductsByCategory(List<String> names);
}
