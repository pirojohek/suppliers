package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.ProductPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.ProductPresentationV1;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
@Tag(name = "Product", description = "Получить информацию о продукте")
public class FindProductRestController {

    private final FindProductApi findProductApi;

    private final ProductPresentationMapper mapper;

    @GetMapping("{id:\\d+}")
    @Operation(summary = "Найти продукт по id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Продукт найден",
                    content = @Content(schema = @Schema(implementation = ProductPresentationV1.class))),
            @ApiResponse(responseCode = "404", description = "Продукт не найден", content = @Content)
    })
    public ResponseEntity<ProductPresentationV1> findProduct(
            @PathVariable("id") Long id
    ){
        var result = this.findProductApi.findProductById(id);
        return ResponseEntity.ok(mapper.productDataToProductPresentationV1(result));
    }
}
