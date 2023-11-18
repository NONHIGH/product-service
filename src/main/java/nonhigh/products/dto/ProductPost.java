package nonhigh.products.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonhigh.products.entity.Category;
import java.util.Date;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
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
