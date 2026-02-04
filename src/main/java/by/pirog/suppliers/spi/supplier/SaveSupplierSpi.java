package by.pirog.suppliers.spi.supplier;


import by.pirog.suppliers.data.supplier.CreateSupplierRequestData;
import by.pirog.suppliers.data.supplier.SupplierData;

@FunctionalInterface
public interface SaveSupplierSpi {
    SupplierData createSupplier(CreateSupplierRequestData requestData);
}
