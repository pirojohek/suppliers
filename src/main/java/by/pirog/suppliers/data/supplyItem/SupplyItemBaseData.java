package by.pirog.suppliers.data.supplyItem;

import by.pirog.suppliers.data.product.ProductData;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SupplyItemBaseData(
        ProductData productData,
        BigDecimal weightKg,
        BigDecimal pricePerKg
) {
}
