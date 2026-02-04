package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.SaveProductApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.ProductPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.ProductPresentationV1;
import by.pirog.suppliers.data.product.CreateProductRequestData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Product", description = "Создать продукт")
public class SaveProductRestController {

    private final ProductPresentationMapper productPresentationMapper;
    private final SaveProductApi saveProductApi;

    @PostMapping
    @Operation(summary = "Создать продукт")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Продукт создан",
                    content = @Content(schema = @Schema(implementation = ProductPresentationV1.class)))
    })
    public ResponseEntity<ProductPresentationV1> createProduct(
            @RequestBody CreateProductRequestData requestData
    ) {
        var createdProduct = this.saveProductApi.createProduct(requestData);

        return ResponseEntity.created(URI.create("/api/product/%d".formatted(createdProduct.id())))
                .body(productPresentationMapper
                        .productDataToProductPresentationV1(createdProduct));
    }
}
