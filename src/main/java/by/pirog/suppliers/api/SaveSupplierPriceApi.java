package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supplierPrice.CreateSupplierPriceRequestData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;

@FunctionalInterface
public interface SaveSupplierPriceApi {

    SupplierProductPriceData createSupplierPrice(CreateSupplierPriceRequestData requestData);
}
