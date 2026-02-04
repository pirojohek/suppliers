package by.pirog.suppliers.spi.supplyItem;

import by.pirog.suppliers.data.supplyItem.SupplyItemBaseData;

import java.util.List;

@FunctionalInterface
public interface FindSupplyItemsBySupplyIdSpi {
    List<SupplyItemBaseData> findSupplyItems(Long supplyId);
}
