package by.pirog.suppliers.api.spring.webmvc.presentation;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record SupplierProductPricePresentationV1(
        Long id,
        Long supplierId,
        Long productId,
        BigDecimal price,
        LocalDate dateFrom,
        LocalDate dateTo
) {
}
