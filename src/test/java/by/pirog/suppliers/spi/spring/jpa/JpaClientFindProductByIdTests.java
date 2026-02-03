package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.mapper.ProductMapper;
import by.pirog.suppliers.storage.model.ProductEntity;
import by.pirog.suppliers.storage.repository.ProductRepository;
import by.pirog.suppliers.util.ProductUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JpaClientFindProductByIdTests {

    @Mock
    private ProductRepository repository;

    @Mock
    private ProductMapper mapper;

    @InjectMocks
    private JpaClientFindProductById adapter;

    @Test
    @DisplayName("Test find product by id functionality")
    void givenProductId_whenFindProductById_thenProductIsFound() {
        // given
        ProductEntity product = ProductUtils.getProductEntityPersistent();
        Long id = 1L;
        var mappingResult = mock(ProductData.class);

        when(repository.findById(anyLong()))
                .thenReturn(Optional.of(product));
        when(mapper.productEntityToProductData(any(ProductEntity.class)))
                .thenReturn(mappingResult);

        // when
        var result = adapter.findProductById(id);

        // then
        assertTrue(result.isPresent());
        assertSame(mappingResult, result.get());

        verify(repository).findById(id);
    }

    @Test
    @DisplayName("Test product not found functionality")
    void givenProductId_whenFindById_thenReturnsOptionalEmpty() {
        // given
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // when
        var result = adapter.findProductById(id);

        // then
        assertTrue(result.isEmpty());

        verify(repository).findById(id);
    }
}
