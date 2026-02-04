package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supplyItem.SupplyItemDetailsData;

import java.util.List;

@FunctionalInterface
public interface FindSupplyItemsBySupplyIdApi {
    List<SupplyItemDetailsData> findSupplyItems(Long supplyId);
}
