package by.pirog.suppliers.spi.product;

import by.pirog.suppliers.data.product.ProductData;

import java.util.List;

@FunctionalInterface
public interface FindAllProductsSpi {

    List<ProductData> findAll();
}
