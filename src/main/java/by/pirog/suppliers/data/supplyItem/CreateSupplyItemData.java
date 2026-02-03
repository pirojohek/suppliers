package by.pirog.suppliers.data.supplyItem;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CreateSupplyItemData(
        Long supplyId,
        Long supplyPriceId,
        BigDecimal weightPerKg
) {
}
