package by.pirog.suppliers.api.usecase.supplierPrice;

import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.exception.SupplierProductPriceNotFoundException;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductSupplierPriceSpi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindCurrentProductSupplierPriceUseCaseTests {

    @Mock
    FindCurrentProductSupplierPriceSpi findCurrentProductSupplierPriceSpi;

    @InjectMocks
    FindCurrentProductSupplierPriceUseCase useCase;

    @Test
    @DisplayName("Find current price returns value when present")
    void givenData_whenFindCurrentPrice_thenReturnsPrice() {
        // given
        FindSupplierProductPriceData data = FindSupplierProductPriceData.builder()
                .productId(1L)
                .supplierId(2L)
                .build();
        SupplierProductPriceData priceData = SupplierProductPriceData.builder()
                .id(10L)
                .build();

        when(findCurrentProductSupplierPriceSpi.findCurrentProductPrice(any()))
                .thenReturn(Optional.of(priceData));

        // when
        SupplierProductPriceData result = useCase.findCurrentProductSupplierPrice(data);

        // then
        assertSame(priceData, result);
        verify(findCurrentProductSupplierPriceSpi).findCurrentProductPrice(data);
    }

    @Test
    @DisplayName("Throws when current price not found")
    void givenData_whenPriceNotFound_thenException() {
        // given
        FindSupplierProductPriceData data = FindSupplierProductPriceData.builder()
                .productId(1L)
                .supplierId(2L)
                .build();

        when(findCurrentProductSupplierPriceSpi.findCurrentProductPrice(any()))
                .thenReturn(Optional.empty());

        // when / then
        SupplierProductPriceNotFoundException exception = assertThrows(
                SupplierProductPriceNotFoundException.class,
                () -> useCase.findCurrentProductSupplierPrice(data)
        );
        verify(findCurrentProductSupplierPriceSpi).findCurrentProductPrice(data);
    }
}
