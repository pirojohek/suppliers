package by.pirog.suppliers.api.spring.webmvc.presentation;


import by.pirog.suppliers.enums.ProductType;
import lombok.Builder;

@Builder
public record ProductPresentationV1(
        Long id,
        String name,
        ProductType type
) {
}
