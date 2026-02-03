package by.pirog.suppliers.data.supply;

import by.pirog.suppliers.enums.ProductType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SupplyAcceptItemData(
        ProductType productType,
        BigDecimal weightPerKg
) {
}
