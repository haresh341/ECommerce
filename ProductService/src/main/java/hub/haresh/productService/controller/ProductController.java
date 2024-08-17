package hub.haresh.productService.controller;

import hub.haresh.productService.dto.ProductDTO;
import hub.haresh.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id) {
        try {
            return productService.getProductById(id);
        } catch (hub.haresh.productService.exception.ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
