package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.product.CreateProductRequestData;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.mapper.ProductMapper;
import by.pirog.suppliers.spi.product.SaveProductSpi;
import by.pirog.suppliers.storage.model.ProductEntity;
import by.pirog.suppliers.storage.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaClientSaveProduct implements SaveProductSpi {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductData createProduct(CreateProductRequestData requestData) {
        ProductEntity product = productMapper.createProductRequestToProductEntity(requestData);

        productRepository.save(product);

        return productMapper.productEntityToProductData(product);
    }
}
