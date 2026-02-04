package by.pirog.suppliers.data.product;

import by.pirog.suppliers.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "CreateProductRequest")
public record CreateProductRequestData(
        @Schema(description = "Название продукта", example = "Tasty Apple")
        String name,
        @Schema(description = "Тип продукта",
                implementation = ProductType.class,
                allowableValues = {"APPLE", "PEAR"},
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        ProductType type
) {
}
