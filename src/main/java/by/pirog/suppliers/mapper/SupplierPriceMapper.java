package by.pirog.suppliers.mapper;

import by.pirog.suppliers.data.supplierPrice.CreateSupplierPriceRequestData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.storage.model.SupplierPriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierPriceMapper {

    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "product.id", target = "productId")
    SupplierProductPriceData supplierPriceEntityToSupplierPriceData(SupplierPriceEntity supplierPrice);
}
