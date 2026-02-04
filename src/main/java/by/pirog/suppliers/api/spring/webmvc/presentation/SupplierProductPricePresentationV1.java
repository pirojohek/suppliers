package by.pirog.suppliers.api.spring.webmvc.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Schema(name = "SupplierProductPriceV1")
public record SupplierProductPricePresentationV1(
        @Schema(description = "ID цены", example = "10")
        Long id,
        @Schema(description = "ID поставщика", example = "5")
        Long supplierId,
        @Schema(description = "ID товара", example = "1")
        Long productId,
        @Schema(description = "Цена за кг", example = "12.50")
        BigDecimal price,
        @Schema(description = "Дата начала действия", example = "2026-02-04")
        LocalDate dateFrom,
        @Schema(description = "Дата конца действия", example = "2026-02-18")
        LocalDate dateTo
) {
}
