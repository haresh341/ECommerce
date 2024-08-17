package hub.haresh.productService.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageURL;
    private CategoryDTO category;
}
