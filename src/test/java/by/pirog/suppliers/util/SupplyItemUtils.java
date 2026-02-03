package by.pirog.suppliers.util;

import by.pirog.suppliers.storage.model.SupplierPriceEntity;
import by.pirog.suppliers.storage.model.SupplyEntity;
import by.pirog.suppliers.storage.model.SupplyItemEntity;

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

    public static SupplyItemEntity getSupplyItemEntityPersistent(
            SupplyEntity supply,
            SupplierPriceEntity supplierPrice
    ){
        return SupplyItemEntity.builder()
                .id(1L)
                .supply(supply)
                .supplierPrice(supplierPrice)
                .weightPerKg(BigDecimal.valueOf(200))
                .build();
    }
}
