package by.pirog.suppliers.util;

import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.enums.ProductType;
import by.pirog.suppliers.storage.model.ProductEntity;

public class ProductUtils {

    public static ProductEntity getProductEntityTransient(){
        return ProductEntity.builder()
                .name("Golden Apple")
                .type(ProductType.APPLE)
                .build();
    }

    public static ProductEntity getProductEntityPersistent(){
        return ProductEntity.builder()
                .id(1L)
                .name("Golden Apple")
                .type(ProductType.APPLE)
                .build();
    }

    public static ProductData getProductData(){
        return ProductData.builder()
                .productType(ProductType.APPLE)
                .id(1L)
                .name("Golden Apple")
                .build();
    }
}
