package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.SaveProductApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.ProductPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.ProductPresentationV1;
import by.pirog.suppliers.data.product.CreateProductRequestData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class SaveProductRestController {

    private final ProductPresentationMapper productPresentationMapper;
    private final SaveProductApi saveProductApi;

    @PostMapping
    public ResponseEntity<ProductPresentationV1> createProduct(
            @RequestBody CreateProductRequestData requestData
    ) {
        var createdProduct = this.saveProductApi.createProduct(requestData);

        return ResponseEntity.created(URI.create("/api/product/%d".formatted(createdProduct.id())))
                .body(productPresentationMapper
                        .productDataToProductPresentationV1(createdProduct));
    }
}
