package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;

import java.time.LocalDate;

@FunctionalInterface
public interface FindCurrentProductPriceByProductIdApi {

    SupplierProductPriceData findCurrentProductPriceByProductId(Long productId, LocalDate date);
}
