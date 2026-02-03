package by.pirog.suppliers.spi.supply;

import by.pirog.suppliers.data.supply.CreateSupplyData;

@FunctionalInterface
public interface SaveSupplySpi {
    Long saveSupply(CreateSupplyData supplyData);
}
