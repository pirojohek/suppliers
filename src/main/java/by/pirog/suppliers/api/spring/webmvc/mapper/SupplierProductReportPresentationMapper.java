package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.api.spring.webmvc.presentation.SupplierProductReportPresentationV1;
import by.pirog.suppliers.data.supplier.SupplierProductReportData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplierProductReportPresentationMapper {

    @Mapping(target = "productType", expression = "java(data.productType().name())")
    SupplierProductReportPresentationV1 supplierProductReportDataToPresentation(SupplierProductReportData data);
}

