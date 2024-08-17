package hub.haresh.productService.service;

import hub.haresh.productService.dto.FakeStoreProductDTO;
import hub.haresh.productService.dto.ProductDTO;
import hub.haresh.productService.exception.ProductNotFoundException;
import hub.haresh.productService.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class FakeStoreProductService implements ProductService {

    private final RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public ProductDTO getProductById(Long id) throws ProductNotFoundException {
        if (id < 1 || id > 20) {
            throw new ProductNotFoundException(Constants.PRODUCT_NOT_FOUND_WITH_ID + id);
        }

        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTO = restTemplate.getForEntity(Constants.FAKE_STORE_URL + "/products/{id}", FakeStoreProductDTO.class, id);
        return Objects.requireNonNull(fakeStoreProductDTO.getBody()).convertToProductDTO();
    }
}
