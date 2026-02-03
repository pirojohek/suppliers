package by.pirog.suppliers.util;

import by.pirog.suppliers.model.SupplierEntity;
import by.pirog.suppliers.model.SupplyEntity;

import java.time.LocalDate;

public class SupplyUtils {

    public static SupplyEntity getSupplyEntityTransient(SupplierEntity supplier){
        return SupplyEntity.builder()
                .supplyDate(LocalDate.now())
                .supplier(supplier)
                .build();
    }
}
