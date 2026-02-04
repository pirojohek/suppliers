package by.pirog.suppliers.api.usecase.supply;

import by.pirog.suppliers.api.*;
import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.data.supply.SupplyAcceptData;
import by.pirog.suppliers.data.supply.SupplyBaseData;
import by.pirog.suppliers.data.supply.SupplyDetailsData;
import by.pirog.suppliers.data.supplyItem.SupplyItemDetailsData;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
public class GetSupplyDetailsUseCase implements GetSupplyDetailsApi {

    private final FindSupplyItemsBySupplyIdApi findSupplyItemsBySupplyIdApi;
    private final FindSupplyByIdApi findSupplyByIdApi;
    private final FindSupplierApi findSupplierApi;

    @Override
    public SupplyDetailsData getSupplyDetails(Long supplyId) {
        SupplyBaseData supply = this.findSupplyByIdApi.findSupply(supplyId);

        List<SupplyItemDetailsData> items = this.findSupplyItemsBySupplyIdApi.findSupplyItems(supplyId);

        SupplierData supplier = findSupplierApi.findSupplierById(supply.supplierId());

        BigDecimal totalWeight = items.stream()
                .map(SupplyItemDetailsData::weightKg)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalCost = items.stream()
                .map(SupplyItemDetailsData::cost)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return SupplyDetailsData.builder()
                .supplyDate(supply.supplyDate())
                .supplyId(supplyId)
                .supplier(supplier)
                .totalWeight(totalWeight)
                .items(items)
                .totalCost(totalCost)
                .build();
    }
}
