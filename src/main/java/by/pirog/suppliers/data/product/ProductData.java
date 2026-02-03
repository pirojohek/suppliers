package by.pirog.suppliers.data.product;

import by.pirog.suppliers.enums.ProductType;
import lombok.Builder;

@Builder
public record ProductData(
        Long id,

        String name,

        ProductType productType
) {
}
