package by.pirog.suppliers.api;

import by.pirog.suppliers.data.ProductData;

public interface FindProductApi {
    ProductData findProductById(Long id);
}
