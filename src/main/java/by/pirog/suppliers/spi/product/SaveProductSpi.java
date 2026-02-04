package by.pirog.suppliers.spi.product;

import by.pirog.suppliers.data.product.CreateProductRequestData;
import by.pirog.suppliers.data.product.ProductData;

@FunctionalInterface
public interface SaveProductSpi {
    ProductData createProduct(CreateProductRequestData requestData);
}
