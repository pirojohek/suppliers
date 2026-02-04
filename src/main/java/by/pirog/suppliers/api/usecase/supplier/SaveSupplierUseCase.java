package by.pirog.suppliers.api.usecase.supplier;

import by.pirog.suppliers.api.SaveSupplierApi;
import by.pirog.suppliers.data.supplier.CreateSupplierRequestData;
import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.spi.supplier.SaveSupplierSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveSupplierUseCase implements SaveSupplierApi {

    private final SaveSupplierSpi saveSupplierSpi;

    @Override
    public SupplierData createSupplier(CreateSupplierRequestData requestData) {
        return this.saveSupplierSpi.createSupplier(requestData);
    }
}
