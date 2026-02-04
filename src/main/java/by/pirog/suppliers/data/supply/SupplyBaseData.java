package by.pirog.suppliers.data.supply;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record SupplyBaseData(
        Long supplyId,
        Long supplierId,
        LocalDate supplyDate
) {}