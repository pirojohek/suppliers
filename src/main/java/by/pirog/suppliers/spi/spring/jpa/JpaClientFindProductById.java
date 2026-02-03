package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.model.ProductEntity;
import by.pirog.suppliers.repository.ProductRepository;
import by.pirog.suppliers.spi.product.FindProductByIdSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@RequiredArgsConstructor
public class JpaClientFindProductById implements FindProductByIdSpi {

    private final ProductRepository productRepository;

    @Override
    public Optional<ProductData> findProductById(Long id) {
        Optional<ProductEntity> productEntity = this.productRepository.findById(id);

        return productEntity.map(entity -> ProductData.builder()
                .productType(entity.getType())
                .name(entity.getName())
                .id(entity.getId())
                .build());
    }
}
