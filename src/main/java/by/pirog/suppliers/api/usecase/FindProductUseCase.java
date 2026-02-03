package by.pirog.suppliers.api.usecase;

import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.data.ProductData;
import by.pirog.suppliers.exception.ProductNotFoundException;
import by.pirog.suppliers.spi.product.FindProductByIdSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindProductUseCase implements FindProductApi {

    private final FindProductByIdSpi findProductByIdSpi;

    @Override
    public ProductData findProductById(Long id) {
        return this.findProductByIdSpi.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Продукт с id: " + id + " не найден"));
    }
}
