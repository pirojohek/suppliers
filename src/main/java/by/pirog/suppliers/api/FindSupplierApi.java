package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supplier.SupplierData;

public interface FindSupplierApi {

    SupplierData findSupplierById(Long supplier);
}
