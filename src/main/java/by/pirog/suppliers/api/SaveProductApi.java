package by.pirog.suppliers.api;

import by.pirog.suppliers.data.product.CreateProductRequestData;
import by.pirog.suppliers.data.product.ProductData;

@FunctionalInterface
public interface SaveProductApi {

    ProductData createProduct(CreateProductRequestData requestData);
}
