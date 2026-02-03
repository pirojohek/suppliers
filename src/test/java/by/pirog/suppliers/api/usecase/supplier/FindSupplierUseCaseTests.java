package by.pirog.suppliers.api.usecase.supplier;

import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.exception.SupplierNotFoundException;
import by.pirog.suppliers.spi.supplier.FindSupplierByIdSpi;
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
public class FindSupplierUseCaseTests {

    @Mock
    FindSupplierByIdSpi findSupplierByIdSpi;

    @InjectMocks
    FindSupplierUseCase useCase;

    @Test
    @DisplayName("Test find supplier by id UseCase functionality")
    void givenSupplierId_whenFindSupplierById_thenReturnsSupplier() {
        // given
        Long id = 1L;
        SupplierData supplierData = SupplierData.builder()
                .id(id)
                .build();

        when(findSupplierByIdSpi.findSupplierById(anyLong()))
                .thenReturn(Optional.of(supplierData));

        // when
        SupplierData result = useCase.findSupplierById(id);

        // then
        assertSame(supplierData, result);
        verify(findSupplierByIdSpi).findSupplierById(id);
    }

    @Test
    @DisplayName("Test supplier not found by id Exception")
    void givenSupplierId_whenFindById_thenSupplierNotFoundException() {
        // given
        Long id = 1L;

        when(findSupplierByIdSpi.findSupplierById(anyLong()))
                .thenReturn(Optional.empty());

        // when / then
        SupplierNotFoundException exception = assertThrows(
                SupplierNotFoundException.class,
                () -> useCase.findSupplierById(id)
        );
        verify(findSupplierByIdSpi).findSupplierById(id);
    }
}
