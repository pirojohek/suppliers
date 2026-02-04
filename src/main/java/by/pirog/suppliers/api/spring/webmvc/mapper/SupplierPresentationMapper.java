package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.api.spring.webmvc.presentation.SupplierPresentationV1;
import by.pirog.suppliers.data.supplier.SupplierData;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface SupplierPresentationMapper {

    SupplierPresentationV1 supplierDataToSupplierPresentationV1(SupplierData data);
}
