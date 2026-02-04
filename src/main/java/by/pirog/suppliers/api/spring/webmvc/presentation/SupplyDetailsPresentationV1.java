package by.pirog.suppliers.api.spring.webmvc.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
@Schema(name = "SupplyDetailsV1", description = "Детали поставки")
public record SupplyDetailsPresentationV1(
        @Schema(description = "ID поставки", example = "100")
        Long supplyId,
        @Schema(description = "Дата поставки", example = "2024-12-01")
        LocalDate supplyDate,
        @Schema(description = "Информация о поставщике")
        SupplierPresentationV1 supplier,
        @Schema(description = "Позиции поставки")
        List<SupplyDetailsItemPresentationV1> items,
        @Schema(description = "Общий вес, кг", example = "120.0")
        BigDecimal totalWeight,
        @Schema(description = "Общая стоимость", example = "350.50")
        BigDecimal totalCost
) {
}
