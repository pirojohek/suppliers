package by.pirog.suppliers.api.spring.webmvc.presentation;

import lombok.Builder;

@Builder
public record AcceptSupplyPresentationV1(
        Long supplyId
) {
}
