package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.api.spring.webmvc.presentation.SupplyDetailsPresentationV1;
import by.pirog.suppliers.data.supply.SupplyDetailsData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplyPresentationMapper {

    SupplyDetailsPresentationV1 supplyDetailsToSupplyPresentationV1(SupplyDetailsData supplyDetailsData);
}
