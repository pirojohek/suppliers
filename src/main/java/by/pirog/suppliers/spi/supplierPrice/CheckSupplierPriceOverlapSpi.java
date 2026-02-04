package by.pirog.suppliers.spi.supplierPrice;

import java.time.LocalDate;

@FunctionalInterface
public interface CheckSupplierPriceOverlapSpi {
    boolean hasOverlappingPrice(
            Long supplierId,
            Long productId,
            LocalDate dateFrom,
            LocalDate dateTo
    );
}
