package by.pirog.suppliers.spi.supplierPrice;

import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;

import java.time.LocalDate;
import java.util.Optional;

@FunctionalInterface
public interface FindCurrentProductPriceByProductIdSpi {
    Optional<SupplierProductPriceData> findCurrentProductPriceByProductId(Long productId, LocalDate date);
}
