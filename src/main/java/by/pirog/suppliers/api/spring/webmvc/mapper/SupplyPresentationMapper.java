package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.api.spring.webmvc.presentation.SupplyDetailsPresentationV1;
import by.pirog.suppliers.data.supply.SupplyDetailsData;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {SupplierPresentationMapper.class, SupplyDetailsPresentationMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SupplyPresentationMapper {

    SupplyDetailsPresentationV1 supplyDetailsToSupplyPresentationV1(SupplyDetailsData supplyDetailsData);
}
