package nonhigh.products.service;

import nonhigh.products.dto.ProductPost;
import nonhigh.products.entity.MessageResponse;
import nonhigh.products.entity.Product;
import nonhigh.products.repository.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImplementation.class);

    @Autowired
    ProductRepository repository;

    @Override
    public ResponseEntity<List<Product>> findProducts() {
        try {
            List<Product> products = repository.findAll();
            if (products.isEmpty()) {
                throw new Exception("No hay productos en la base de datos");
            }
            return ResponseEntity.ok().body(products);
        } catch (Exception e) {
            log.error("Error al buscar productos", e);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @Override
    public ResponseEntity<Product> findProductById(Long id) {
        try {
            Optional<Product> productFound = repository.findById(id);
            return productFound.map(product -> ResponseEntity.ok().body(product))
                    .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
        } catch (Exception e) {
            log.error("Error al buscar un producto", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Product> createProduct(ProductPost product) {
        try {
            Product productToSave = new Product();
            productToSave.setCategory(product.getCategory());
            productToSave.setCreateAt(product.getCreateAt());
            productToSave.setDescription(product.getDescription());
            productToSave.setName(product.getName());
            productToSave.setStatus(product.getStatus());
            productToSave.setStock(product.getStock());
            productToSave.setPrice(product.getPrice());
            Product saved = repository.save(productToSave);
            if (saved == null) {
                throw new Exception("No se pudo guardar el producto en la base de datos");
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Error al crear un producto", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long id) {
        try {
            Optional<Product> productFound = repository.findById(id);
            if (productFound.isEmpty()) {
                MessageResponse messageResponse = new MessageResponse();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageResponse);
            }
            repository.delete(productFound.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            log.error("Error al eliminar un producto: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Product> editProduct(Product product, Long idProduct) {
        try {
            Optional<Product> productFound = repository.findById(idProduct);
            if (productFound.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            Product existingProduct = productFound.get();
            existingProduct.setName(product.getName());
            existingProduct.setCategory(product.getCategory());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStatus(product.getStatus());
            existingProduct.setStock(product.getStock());
            existingProduct.setDescription(product.getDescription());
            repository.save(existingProduct);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            log.error("Error al editar un producto", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<Product> editStockProduct(Long id, Double stock) {
        try {
            Optional<Product> productFound = repository.findById(id);
            if(productFound.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            Product existingProduct = productFound.get();
            existingProduct.setStock(stock);
            repository.save(existingProduct);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            log.error("Error al editar el stock", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<List<Product>> findProductsByCategory(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductsByCategory'");
    }

    @Override
    public ResponseEntity<List<Product>> findProductsByCategory(List<String> names) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findProductsByCategory'");
    }
    
}
