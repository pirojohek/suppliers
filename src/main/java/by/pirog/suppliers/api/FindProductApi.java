package by.pirog.suppliers.api;

import by.pirog.suppliers.data.product.ProductData;

public interface FindProductApi {
    ProductData findProductById(Long id);
}
