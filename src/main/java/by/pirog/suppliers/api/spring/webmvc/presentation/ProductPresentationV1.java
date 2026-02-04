package by.pirog.suppliers.api.spring.webmvc.presentation;


import by.pirog.suppliers.enums.ProductType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "ProductV1", description = "Описание товара")
public record ProductPresentationV1(
        @Schema(description = "Идентификатор товара", example = "101")
        Long id,
        @Schema(description = "Название товара", example = "Яблочко")
        String name,
        @Schema(description = "Тип товара", example = "Apple")
        ProductType type
) {
}
