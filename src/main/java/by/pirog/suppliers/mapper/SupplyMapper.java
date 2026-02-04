package by.pirog.suppliers.mapper;

import by.pirog.suppliers.data.supply.SupplyBaseData;
import by.pirog.suppliers.storage.model.SupplyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SupplyMapper {

    @Mapping(source = "id", target = "supplyId")
    @Mapping(source = "supplier.id", target = "supplierId")
    @Mapping(source = "supplyDate", target = "supplyDate")
    SupplyBaseData supplyEntityToSupplyBaseData(SupplyEntity entity);
}
