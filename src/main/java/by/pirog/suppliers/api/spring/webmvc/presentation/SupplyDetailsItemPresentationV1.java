package by.pirog.suppliers.api.spring.webmvc.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@Schema(name = "SupplyDetailsItemV1", description = "Позиция в поставке")
public record SupplyDetailsItemPresentationV1(
        @Schema(description = "ID товара", example = "10")
        Long productId,
        @Schema(description = "Название товара", example = "Сахар")
        String productName,
        @Schema(description = "Вес, кг", example = "25.5")
        BigDecimal weight,
        @Schema(description = "Цена за кг", example = "3.45")
        BigDecimal pricePerKg,
        @Schema(description = "Стоимость позиции", example = "88.0")
        BigDecimal cost
) {
}

