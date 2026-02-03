package by.pirog.suppliers.data.supply;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CreateSupplyData(
        Long supplierId,
        LocalDate supplyDate
) {
}
