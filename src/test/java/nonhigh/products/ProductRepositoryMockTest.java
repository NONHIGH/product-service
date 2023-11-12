package nonhigh.products;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import nonhigh.products.repository.ProductRepository;
import nonhigh.products.entity.Product;
import nonhigh.products.entity.Category;
import nonhigh.products.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    
    
    @Test
    @Sql(statements = {
            "CREATE TABLE IF NOT EXISTS tbl_categories (id BIGINT AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY (id))",
            "CREATE TABLE IF NOT EXISTS tbl_products (id BIGINT AUTO_INCREMENT, name VARCHAR(255), description TEXT, stock INT, price DECIMAL(10, 2), status VARCHAR(50), create_at DATE, category_id BIGINT, PRIMARY KEY (id), FOREIGN KEY (category_id) REFERENCES tbl_categories(id))",
            "CREATE TABLE IF NOT EXISTS product_category (product_id BIGINT, category_id BIGINT, FOREIGN KEY (product_id) REFERENCES tbl_products(id), FOREIGN KEY (category_id) REFERENCES tbl_categories(id), PRIMARY KEY (product_id, category_id))",
            "INSERT INTO tbl_categories (id, name) VALUES (1, 'shoes')",
            "INSERT INTO tbl_categories (id, name) VALUES (2, 'books')",
            "INSERT INTO tbl_categories (id, name) VALUES (3, 'electronics')",
            "INSERT INTO tbl_products (id, name, description, stock, price, status, create_at, category_id) VALUES (1, 'adidas Cloudfoam Ultimate', 'Walk in the air in the black / black CLOUDFOAM ULTIMATE running shoe from ADIDAS', 5, 178.89, 'CREATED', '2018-09-05', 1)",
            "INSERT INTO tbl_products (id, name, description, stock, price, status, create_at, category_id) VALUES (2, 'under armour Men ''s Micro G Assert – 7', 'under armour Men ''Lightweight mesh upper delivers complete breathability . Durable leather overlays for stability ', 4, 12.5, 'CREATED', '2018-09-05', 1)",
            "INSERT INTO tbl_products (id, name, description, stock, price, status, create_at, category_id) VALUES (3, 'Spring Boot in Action', 'under armour Men '' Craig Walls is a software developer at Pivotal and is the author of Spring in Action', 12, 40.06, 'CREATED', '2018-09-05', 2)"
    })
    public void whenFindByCategory_thenReturnListProduct() {
        System.out.println(categoryRepository.findAll());
        final Category category = categoryRepository.findById(1L).orElse(null);
        System.out.println("soy la =>" + category);
        if (category != null) {
            Product product = Product.builder()
                    .name("computer")
                    .description("Esta es una buena computadora xd")
                    .category(category)
                    .price(Double.parseDouble("183.99"))
                    .stock(Double.parseDouble("1203.99"))
                    .status("hot")
                    .build();
            productRepository.save(product);
            List<Product> products = productRepository.findByCategory(product.getCategory());
            Assertions.assertThat(products.size()).isEqualTo(3);
        } else {
            System.out.println("La no fue.");
        }
        System.out.println(productRepository.findAll() + " las");
        
    }
}
