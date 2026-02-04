package by.pirog.suppliers.data.supply;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Schema(name = "SupplyAcceptItem")
public record SupplyAcceptItemData(
        @Schema(description = "Id продукта", example = "10")
        @NotNull(message = "productId is required")
        Long productId,
        @Schema(description = "Вес продукта в килограммах", example = "12.5")
        @NotNull(message = "weightPerKg is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "weightPerKg must be greater than 0")
        BigDecimal weightPerKg
) {
}
