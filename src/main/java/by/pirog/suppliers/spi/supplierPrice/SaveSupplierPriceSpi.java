package by.pirog.suppliers.spi.supplierPrice;

import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.data.supplierPrice.CreateSupplierPriceRequestData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;

@FunctionalInterface
public interface SaveSupplierPriceSpi {

    SupplierProductPriceData saveSupplierPrice(CreateSupplierPriceRequestData requestData);
}
