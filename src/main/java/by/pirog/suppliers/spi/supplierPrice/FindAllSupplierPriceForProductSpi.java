package by.pirog.suppliers.spi.supplierPrice;

import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface FindAllSupplierPriceForProductSpi {
    List<SupplierProductPriceData> findAll(Long productId, LocalDate date);
}
