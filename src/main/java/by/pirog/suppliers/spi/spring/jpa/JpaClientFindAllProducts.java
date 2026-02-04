package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.mapper.ProductMapper;
import by.pirog.suppliers.spi.product.FindAllProductsSpi;
import by.pirog.suppliers.storage.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaClientFindAllProducts implements FindAllProductsSpi {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public List<ProductData> findAll() {
        var result = this.productRepository.findAll();

        return result.stream().map(productMapper::productEntityToProductData)
                .toList();
    }
}
