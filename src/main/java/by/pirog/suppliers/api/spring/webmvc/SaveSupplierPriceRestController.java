package by.pirog.suppliers.api.spring.webmvc;


import by.pirog.suppliers.api.spring.webmvc.mapper.SupplierPricePresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.SupplierProductPricePresentationV1;
import by.pirog.suppliers.api.usecase.supplierPrice.SaveSupplierPriceUseCase;
import by.pirog.suppliers.data.supplierPrice.CreateSupplierPriceRequestData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supplier-price")
@Tag(name = "SupplierPrice", description = "Создание цен поставщиков")
public class SaveSupplierPriceRestController {

    private final SupplierPricePresentationMapper presentationMapper;
    private final SaveSupplierPriceUseCase saveSupplierPriceUseCase;

    @PostMapping
    @Operation(summary = "Создать цену поставщика на товар")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Цена создана",
                    content = @Content(schema = @Schema(implementation = SupplierProductPricePresentationV1.class))),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    public ResponseEntity<SupplierProductPricePresentationV1> saveSupplierPrice(
            @Valid @RequestBody CreateSupplierPriceRequestData requestData
    ) {
        var result = this.saveSupplierPriceUseCase.createSupplierPrice(requestData);

        return ResponseEntity.created(URI.create("/api/supplier-price/%d".formatted(result.id())))
                .body(presentationMapper.supplierPriceDataToSupplierPresentation(result));
    }
}
