package nonhigh.products.service;

import nonhigh.products.dto.ProductEdit;
import nonhigh.products.dto.ProductPost;
import nonhigh.products.entity.Product;
import nonhigh.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service

public class ProductServiceImplementation implements ProductService{

    @Autowired
    ProductRepository repository;
    @Override
    public ResponseEntity<List<Product>> findProducts() {
        try {
            List<Product> products = repository.findAll();
            if(products.isEmpty()){
                throw new Exception("No hay productos en la base de datos");
            }
            return ResponseEntity.ok().body(products);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Product> findProductById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> createProduct(ProductPost product) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Product> editProduct(ProductEdit product) {
        return null;
    }
}
