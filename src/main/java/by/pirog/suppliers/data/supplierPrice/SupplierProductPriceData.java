package by.pirog.suppliers.data.supplierPrice;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record SupplierProductPriceData(
        Long id,
        Long supplierId,
        Long productId,
        BigDecimal price,
        LocalDate dateFrom,
        LocalDate dateTo
) {
}
