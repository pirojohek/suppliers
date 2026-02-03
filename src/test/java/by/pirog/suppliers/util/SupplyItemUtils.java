package by.pirog.suppliers.util;

import by.pirog.suppliers.model.SupplierPriceEntity;
import by.pirog.suppliers.model.SupplyEntity;
import by.pirog.suppliers.model.SupplyItemEntity;

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
