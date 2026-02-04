package by.pirog.suppliers.data.product;

import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import lombok.Builder;

import java.util.List;

@Builder
public record ProductWithAllPricesData(
    ProductData product,
    List<SupplierProductPriceData> prices
){

}
