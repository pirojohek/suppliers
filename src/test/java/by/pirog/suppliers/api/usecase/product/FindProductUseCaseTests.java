package by.pirog.suppliers.api.usecase.product;

import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.exception.ProductNotFoundException;
import by.pirog.suppliers.spi.product.FindProductByIdSpi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindProductUseCaseTests {

    @Mock
    FindProductByIdSpi findProductByIdSpi;

    @InjectMocks
    FindProductUseCase useCase;

    @Test
    @DisplayName("Test find product by id UseCase functionality")
    void givenProductId_whenFindProductById_thenReturnsProduct() {
        // given
        Long id = 1L;
        ProductData productData = ProductData.builder()
                .id(id)
                .build();

        when(findProductByIdSpi.findProductById(anyLong()))
                .thenReturn(Optional.of(productData));

        // when
        ProductData result = useCase.findProductById(id);

        // then
        assertSame(productData, result);
        verify(findProductByIdSpi).findProductById(id);
    }


    @Test
    @DisplayName("Test product not found by id Exception")
    void givenProductId_whenFindById_thenProductNotFoundException() {
        // given
        Long id = 1L;

        when(findProductByIdSpi.findProductById(anyLong()))
                .thenReturn(Optional.empty());

        // when / then
        ProductNotFoundException exception = assertThrows(
                ProductNotFoundException.class,
                () -> useCase.findProductById(id)
        );
        verify(findProductByIdSpi).findProductById(id);
    }
}
