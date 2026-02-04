package by.pirog.suppliers.api.spring.webmvc.presentation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.util.List;

@Builder
@Schema(name = "ProductsWithPricesV1", description = "Товар с ценами поставщиков на дату")
public record ProductsWithPricesPresentationV1(
        @Schema(description = "Информация о товаре")
        ProductPresentationV1 product,
        @Schema(description = "Цены поставщиков для товара")
        List<SupplierProductPricePresentationV1> prices
) {
}
