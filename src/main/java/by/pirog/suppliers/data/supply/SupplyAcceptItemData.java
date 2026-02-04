package by.pirog.suppliers.data.supply;

import by.pirog.suppliers.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
@Schema(name = "SupplyAcceptItem")
public record SupplyAcceptItemData(
        @Schema(description = "Id продукта", example = "10")
        Long productId,
        @Schema(description = "Вес продукта в килограммах", example = "12.5")
        BigDecimal weightPerKg
) {
}
