package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supply.SupplyBaseData;

@FunctionalInterface
public interface FindSupplyByIdApi {
    SupplyBaseData findSupply(Long supplyId);
}
