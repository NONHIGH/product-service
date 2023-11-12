package nonhigh.products.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import nonhigh.products.entity.Category;

import java.util.Date;

@Data
@AllArgsConstructor
public class ProductPost {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Double stock;
    private String status;
    private Date createAt;
    private Category category;

}
