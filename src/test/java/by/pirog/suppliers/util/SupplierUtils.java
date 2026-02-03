package by.pirog.suppliers.util;

import by.pirog.suppliers.storage.model.SupplierEntity;

public class SupplierUtils {

    public static SupplierEntity getSupplierEntityTransient(){
        return SupplierEntity.builder()
                .name("ООО ОГОГО")
                .build();
    }
}
