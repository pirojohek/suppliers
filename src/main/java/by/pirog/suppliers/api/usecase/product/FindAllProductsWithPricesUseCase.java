package by.pirog.suppliers.api.usecase.product;

import by.pirog.suppliers.api.FindAllProductsWithPricesInDateApi;
import by.pirog.suppliers.data.product.ProductWithAllPricesData;
import by.pirog.suppliers.spi.product.FindAllProductsSpi;
import by.pirog.suppliers.spi.supplierPrice.FindAllSupplierPriceForProductSpi;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class FindAllProductsWithPricesUseCase implements FindAllProductsWithPricesInDateApi {

    private final FindAllProductsSpi findAllProductsSpi;
    private final FindAllSupplierPriceForProductSpi findAllSupplierPriceForProductSpi;

    @Override
    public List<ProductWithAllPricesData> findAll(LocalDate date) {
        var products = this.findAllProductsSpi.findAll();
        List<ProductWithAllPricesData> response = products.stream()
                .map(product -> ProductWithAllPricesData.builder()
                        .product(product)
                        .prices(findAllSupplierPriceForProductSpi.findAll(product.id(), date))
                        .build()).toList();

        return response;
    }
}
