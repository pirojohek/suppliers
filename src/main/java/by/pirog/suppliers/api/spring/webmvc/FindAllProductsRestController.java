package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.FindAllProductsWithPricesInDateApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.ProductPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.mapper.SupplierPricePresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.ProductsWithPricesPresentationV1;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products/detailed")
@Tag(name = "Product", description = "Получить товары с ценами поставщиков на дату")
public class FindAllProductsRestController {

    private final FindAllProductsWithPricesInDateApi findAllProductsWithPricesInDateApi;

    private final ProductPresentationMapper productMapper;
    private final SupplierPricePresentationMapper supplierPriceMapper;

    @GetMapping
    @Operation(summary = "Получить все товары с ценами поставщиков",
            description = "Возвращает список товаров с деталями и ценами поставщиков на указанную дату")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список товаров с ценами",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductsWithPricesPresentationV1.class))),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса", content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    public ResponseEntity<List<ProductsWithPricesPresentationV1>> getAllProductsWithPrices(
            @Parameter(description = "Дата, на которую требуется получить цены", example = "2026-02-15", required = true)
            @RequestParam("date") LocalDate date
    ) {
        var result = this.findAllProductsWithPricesInDateApi.findAll(date);

        return ResponseEntity.ok(result.stream().map(item ->
                ProductsWithPricesPresentationV1.builder()
                        .prices(item.prices().stream()
                                .map(supplierPriceMapper::supplierPriceDataToSupplierPresentation)
                                .toList())
                        .product(productMapper.productDataToProductPresentationV1(item.product()))
                        .build()
        ).toList());
    }
}
