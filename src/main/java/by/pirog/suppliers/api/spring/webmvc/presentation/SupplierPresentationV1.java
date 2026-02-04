package by.pirog.suppliers.api.spring.webmvc.presentation;

import lombok.Builder;

@Builder
public record SupplierPresentationV1(
        Long id,
        String name
) {
}
