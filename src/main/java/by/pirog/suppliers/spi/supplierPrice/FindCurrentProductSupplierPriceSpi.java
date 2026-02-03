package by.pirog.suppliers.spi.supplierPrice;

import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;

import java.util.Optional;

@FunctionalInterface
public interface FindCurrentProductSupplierPriceSpi {
    Optional<SupplierProductPriceData> findCurrentProductPrice(FindSupplierProductPriceData data);
}
