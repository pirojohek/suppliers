package by.pirog.suppliers.util;

import by.pirog.suppliers.api.spring.webmvc.presentation.ProductPresentationV1;
import by.pirog.suppliers.enums.ProductType;

public class ProductPresentationUtil {

    public static ProductPresentationV1 getProductPresentationV1(){
        return ProductPresentationV1.builder()
                .type(ProductType.APPLE)
                .name("Golden apple")
                .id(1L)
                .build();
    }
}
