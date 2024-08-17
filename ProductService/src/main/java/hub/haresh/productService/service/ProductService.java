package hub.haresh.productService.service;

import hub.haresh.productService.dto.ProductDTO;
import hub.haresh.productService.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    ProductDTO getProductById(Long id) throws ProductNotFoundException;
    List<ProductDTO> getAllProducts();
}
