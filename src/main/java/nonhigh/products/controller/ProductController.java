package nonhigh.products.controller;

import nonhigh.products.entity.Product;
import nonhigh.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/variable")
    public ResponseEntity<String> demo(@RequestParam String value){
        System.out.println(value + " este es el valor de la query");
        return ResponseEntity.ok(value + "este es un valor pasado a traves de la query");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Product>> findAllProducts(@PathVariable(value = "id") int id){
        System.out.println(id + "este es el valor del id");
        return productService.findProducts();
    }
}
