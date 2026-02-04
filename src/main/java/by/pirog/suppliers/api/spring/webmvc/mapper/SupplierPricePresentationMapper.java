package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.api.spring.webmvc.presentation.SupplierProductPricePresentationV1;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierPricePresentationMapper {


    SupplierProductPricePresentationV1 supplierPriceDataToSupplierPresentation(SupplierProductPriceData data);
}
