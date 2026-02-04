package by.pirog.suppliers.api.usecase.product;

import by.pirog.suppliers.api.SaveProductApi;
import by.pirog.suppliers.data.product.CreateProductRequestData;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.spi.product.SaveProductSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveProductUseCase implements SaveProductApi {


    private final SaveProductSpi saveProductSpi;

    @Override
    public ProductData createProduct(CreateProductRequestData requestData) {
        return this.saveProductSpi.createProduct(requestData);
    }
}
