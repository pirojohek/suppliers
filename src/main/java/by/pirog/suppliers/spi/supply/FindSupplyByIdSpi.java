package by.pirog.suppliers.spi.supply;

import by.pirog.suppliers.data.supply.SupplyBaseData;

import java.util.Optional;

@FunctionalInterface
public interface FindSupplyByIdSpi {
    Optional<SupplyBaseData> findById(Long supplyId);
}
