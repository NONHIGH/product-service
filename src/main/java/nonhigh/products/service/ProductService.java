package nonhigh.products.service;

import nonhigh.products.dto.ProductEdit;
import nonhigh.products.dto.ProductPost;
import nonhigh.products.entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Objects;

public interface ProductService {
    public ResponseEntity<List<Product>> findProducts();

    public ResponseEntity<Product> findProductById(Long id);

    public ResponseEntity<Product> createProduct(ProductPost product);

    public ResponseEntity<?> deleteProduct(Long id);

    public ResponseEntity<Product> editProduct(ProductEdit product);
}
