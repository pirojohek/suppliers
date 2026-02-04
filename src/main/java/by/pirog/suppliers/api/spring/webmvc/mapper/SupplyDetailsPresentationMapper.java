package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.api.spring.webmvc.presentation.SupplyDetailsItemPresentationV1;
import by.pirog.suppliers.api.spring.webmvc.presentation.SupplyDetailsPresentationV1;
import by.pirog.suppliers.data.supply.SupplyDetailsData;
import by.pirog.suppliers.data.supplyItem.SupplyItemDetailsData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = SupplierPresentationMapper.class)
public interface SupplyDetailsPresentationMapper {

    @Mapping(source = "supplyId", target = "supplyId")
    @Mapping(source = "supplyDate", target = "supplyDate")
    @Mapping(source = "supplier", target = "supplier")
    @Mapping(source = "items", target = "items")
    @Mapping(source = "totalWeight", target = "totalWeight")
    @Mapping(source = "totalCost", target = "totalCost")
    SupplyDetailsPresentationV1 toPresentation(SupplyDetailsData details);

    @Mapping(source = "productId", target = "productId")
    @Mapping(source = "productName", target = "productName")
    @Mapping(source = "weightKg", target = "weight")
    @Mapping(source = "pricePerKg", target = "pricePerKg")
    @Mapping(source = "cost", target = "cost")
    SupplyDetailsItemPresentationV1 toItemPresentation(SupplyItemDetailsData item);

    List<SupplyDetailsItemPresentationV1> toItemPresentation(List<SupplyItemDetailsData> items);
}

