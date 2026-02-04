package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supply.SupplyDetailsData;

@FunctionalInterface
public interface GetSupplyDetailsApi {
    SupplyDetailsData getSupplyDetails(Long supplyId);
}
