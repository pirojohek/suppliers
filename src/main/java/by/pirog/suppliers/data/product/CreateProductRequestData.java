package by.pirog.suppliers.data.product;

import by.pirog.suppliers.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
@Schema(name = "CreateProductRequest")
public record CreateProductRequestData(
        @Schema(description = "Название продукта", example = "Tasty Apple")
        @NotBlank(message = "name is required")
        String name,
        @Schema(description = "Тип продукта",
                implementation = ProductType.class,
                allowableValues = {"APPLE", "PEAR"},
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(message = "type is required")
        ProductType type
) {
}
