package by.pirog.suppliers.api.usecase.supplier;

import by.pirog.suppliers.api.FindSupplierApi;
import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.exception.SupplierNotFoundException;
import by.pirog.suppliers.spi.supplier.FindSupplierByIdSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindSupplierUseCase implements FindSupplierApi {

    private final FindSupplierByIdSpi findSupplierByIdSpi;

    @Override
    public SupplierData findSupplierById(Long supplier) {
        return this.findSupplierByIdSpi.findSupplierById(supplier)
                .orElseThrow(() -> new SupplierNotFoundException("Поставщик с id: " + supplier + " не найден"));
    }
}
