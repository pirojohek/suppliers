package by.pirog.suppliers.data.product;

import by.pirog.suppliers.enums.ProductType;
import lombok.Builder;

@Builder
public record CreateProductRequestData(
        String name,
        ProductType productType
) {
}
