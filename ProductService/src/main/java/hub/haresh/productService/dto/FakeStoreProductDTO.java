package hub.haresh.productService.dto;

import lombok.Data;

@Data
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String image;
    private String category;

    public ProductDTO convertToProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.id);
        productDTO.setName(this.title);
        productDTO.setImageURL(this.image);
        productDTO.setPrice(this.price);
        productDTO.setDescription(this.description);
        if (category != null) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(category);
            categoryDTO.setDescription(category);
            productDTO.setCategory(categoryDTO);
        }
        return productDTO;
    }

}
