package by.pirog.suppliers.api;

import by.pirog.suppliers.data.product.ProductWithAllPricesData;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface FindAllProductsWithPricesInDateApi {
    List<ProductWithAllPricesData> findAll(LocalDate date);
}
