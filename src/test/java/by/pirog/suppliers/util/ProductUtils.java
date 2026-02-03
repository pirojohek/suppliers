package by.pirog.suppliers.util;

import by.pirog.suppliers.enums.ProductType;
import by.pirog.suppliers.storage.model.ProductEntity;

public class ProductUtils {

    public static ProductEntity getProductEntityTransient(){
        return ProductEntity.builder()
                .name("Golden Apple")
                .type(ProductType.APPLE)
                .build();
    }
}
