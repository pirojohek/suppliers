package by.pirog.suppliers.data.supply;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record SupplyAcceptData(
        Long supplierId,
        LocalDate supplyDate,
        List<SupplyAcceptItemData> items
) {
}
