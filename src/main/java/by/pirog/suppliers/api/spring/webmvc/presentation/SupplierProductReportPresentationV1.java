package by.pirog.suppliers.api.spring.webmvc.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@Schema(name = "SupplierProductReportV1", description = "Отчет по товарам и поставщикам")
public record SupplierProductReportPresentationV1(
        @Schema(description = "Идентификатор поставщика", example = "10")
        Long supplierId,
        @Schema(description = "Название поставщика", example = "ООО Поставщик")
        String supplierName,
        @Schema(description = "Тип продукта", example = "APPLE")
        String productType,
        @Schema(description = "Общий вес поставки, кг", example = "1200.50")
        BigDecimal totalWeight,
        @Schema(description = "Общая стоимость", example = "34500.75")
        BigDecimal totalCost
) {
}

