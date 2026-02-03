package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.mapper.ProductMapper;
import by.pirog.suppliers.storage.model.ProductEntity;
import by.pirog.suppliers.storage.repository.ProductRepository;
import by.pirog.suppliers.spi.product.FindProductByIdSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class JpaClientFindProductById implements FindProductByIdSpi {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Optional<ProductData> findProductById(Long id) {
        Optional<ProductEntity> productEntity = this.productRepository.findById(id);

        return productEntity.map(productMapper::productEntityToProductData);
    }
}
