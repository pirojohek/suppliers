package by.pirog.suppliers.data.supplyItem;

import by.pirog.suppliers.data.product.ProductData;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SupplyItemDetailsData(
        Long productId,
        String productName,
        BigDecimal weightKg,
        BigDecimal pricePerKg,
        BigDecimal cost
) {
    public static SupplyItemDetailsData from(ProductData productData, BigDecimal weightKg, BigDecimal pricePerKg, BigDecimal cost) {
        return SupplyItemDetailsData.builder()
                .productId(productData.id())
                .productName(productData.name())
                .weightKg(weightKg)
                .pricePerKg(pricePerKg)
                .cost(cost)
                .build();
    }
}
