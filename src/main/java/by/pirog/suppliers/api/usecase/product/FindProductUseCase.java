package by.pirog.suppliers.api.usecase.product;

import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.exception.ProductNotFoundException;
import by.pirog.suppliers.spi.product.FindProductByIdSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindProductUseCase implements FindProductApi {

    private final FindProductByIdSpi findProductByIdSpi;

    @Override
    public ProductData findProductById(Long id) {
        return this.findProductByIdSpi.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Продукт с id: " + id + " не найден"));
    }
}
