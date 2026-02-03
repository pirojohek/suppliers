package by.pirog.suppliers.data;

import by.pirog.suppliers.enums.ProductType;
import lombok.Builder;

@Builder
public record ProductData(
        Long id,

        String name,

        ProductType productType
) {
}
