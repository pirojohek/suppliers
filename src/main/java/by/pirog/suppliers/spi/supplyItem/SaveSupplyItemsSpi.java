package by.pirog.suppliers.spi.supplyItem;

import by.pirog.suppliers.data.supplyItem.CreateSupplyItemData;

import java.util.List;

// Подразумевается, что этот метод будет использоваться для сохранения
// только item от одного поставщика для одной поставки
@FunctionalInterface
public interface SaveSupplyItemsSpi {
    void saveSupplyItems(List<CreateSupplyItemData> data);
}
