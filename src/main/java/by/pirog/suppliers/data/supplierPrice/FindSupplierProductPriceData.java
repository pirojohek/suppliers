package by.pirog.suppliers.data.supplierPrice;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record FindSupplierProductPriceData(
        Long supplierId,
        Long productId,
        LocalDate supplyDate
) {
}
