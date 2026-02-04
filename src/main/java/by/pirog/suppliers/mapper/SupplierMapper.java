package by.pirog.suppliers.mapper;

import by.pirog.suppliers.data.supplier.CreateSupplierRequestData;
import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.storage.model.SupplierEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {

    SupplierData supplierEntityToSupplierData(SupplierEntity entity);

    SupplierEntity createSupplierRequestToSupplierEntity(CreateSupplierRequestData data);
}
