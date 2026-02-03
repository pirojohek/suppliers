package by.pirog.suppliers.util;

import by.pirog.suppliers.storage.model.SupplierEntity;

public class SupplierUtils {

    public static SupplierEntity getSupplierEntityTransient(){
        return SupplierEntity.builder()
                .name("ООО Красная Шапочка")
                .build();
    }

    public static SupplierEntity getSupplierEntityPersistent(){
        return SupplierEntity.builder()
                .id(1L)
                .name("ООО Красная Шапочка")
                .build();
    }
}
