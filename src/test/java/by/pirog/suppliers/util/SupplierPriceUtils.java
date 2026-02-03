package by.pirog.suppliers.util;

import by.pirog.suppliers.core.model.ProductEntity;
import by.pirog.suppliers.core.model.SupplierEntity;
import by.pirog.suppliers.core.model.SupplierPriceEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SupplierPriceUtils {

    public static SupplierPriceEntity getSupplierPriceTransient(
            SupplierEntity supplier,
            ProductEntity product
    ){
        return SupplierPriceEntity.builder()
                .price(BigDecimal.valueOf(300))
                .dateFrom(LocalDate.now().minusDays(2))
                .dateTo(LocalDate.now().plusDays(2))
                .supplier(supplier)
                .product(product)
                .build();
    }
}
