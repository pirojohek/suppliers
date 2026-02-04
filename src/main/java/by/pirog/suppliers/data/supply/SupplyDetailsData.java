package by.pirog.suppliers.data.supply;

import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.data.supplyItem.SupplyItemDetailsData;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Builder
public record SupplyDetailsData(
    Long supplyId,
    LocalDate supplyDate,
    SupplierData supplier,
    List<SupplyItemDetailsData> items,
    BigDecimal totalWeight,
    BigDecimal totalCost
){

}
