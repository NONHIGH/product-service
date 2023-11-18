package nonhigh.products.controller;

import nonhigh.products.dto.ProductPost;
import nonhigh.products.entity.Product;
import nonhigh.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {


    @Autowired
    ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> findAllProducts() {
        return productService.findProducts();
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Product> findProdudt(@PathVariable(value = "id") Long id) {
        return productService.findProductById(id);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductPost product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long id, @RequestBody Product product) {
        return productService.editProduct(product, id);
    }
}