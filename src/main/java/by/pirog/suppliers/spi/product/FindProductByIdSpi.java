package by.pirog.suppliers.spi.product;

import by.pirog.suppliers.data.ProductData;

import java.util.Optional;

@FunctionalInterface
public interface FindProductByIdSpi {
    Optional<ProductData> findProductById(Long id);
}
