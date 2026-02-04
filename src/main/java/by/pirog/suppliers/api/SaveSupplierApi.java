package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supplier.CreateSupplierRequestData;
import by.pirog.suppliers.data.supplier.SupplierData;
import org.springframework.stereotype.Component;

@Component
public interface SaveSupplierApi {
    SupplierData createSupplier(CreateSupplierRequestData requestData);
}
