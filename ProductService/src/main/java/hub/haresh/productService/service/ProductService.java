package hub.haresh.productService.service;

import hub.haresh.productService.dto.ProductDTO;
import hub.haresh.productService.exception.ProductNotFoundException;

public interface ProductService {
    ProductDTO getProductById(Long id) throws ProductNotFoundException;
}
