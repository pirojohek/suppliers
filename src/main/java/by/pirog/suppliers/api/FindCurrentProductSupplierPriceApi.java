package by.pirog.suppliers.api;


import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;

@FunctionalInterface
public interface FindCurrentProductSupplierPriceApi {
    SupplierProductPriceData findCurrentProductSupplierPrice(FindSupplierProductPriceData data);
}
