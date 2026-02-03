package by.pirog.suppliers.util;

import by.pirog.suppliers.core.model.SupplierPriceEntity;
import by.pirog.suppliers.core.model.SupplyEntity;
import by.pirog.suppliers.core.model.SupplyItemEntity;

import java.math.BigDecimal;

public class SupplyItemUtils {

    public static SupplyItemEntity getSupplyItemEntityTransient(
            SupplyEntity supply,
            SupplierPriceEntity supplierPrice
    ){
        return SupplyItemEntity.builder()
                .supply(supply)
                .supplierPrice(supplierPrice)
                .weightPerKg(BigDecimal.valueOf(200))
                .build();
    }
}
