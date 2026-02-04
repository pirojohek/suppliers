package by.pirog.suppliers.api.usecase.supplyItem;

import by.pirog.suppliers.api.FindSupplyItemsBySupplyIdApi;
import by.pirog.suppliers.data.supplyItem.SupplyItemDetailsData;
import by.pirog.suppliers.spi.supplyItem.FindSupplyItemsBySupplyIdSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class FindSupplyItemUseCase implements FindSupplyItemsBySupplyIdApi {

    private final FindSupplyItemsBySupplyIdSpi findSupplyItemsBySupplyIdSpi;

    @Override
    public List<SupplyItemDetailsData> findSupplyItems(Long supplyId) {
        var items = this.findSupplyItemsBySupplyIdSpi.findSupplyItems(supplyId);

        return items.stream().map(item ->
                SupplyItemDetailsData.from(
                        item.productData(),
                        item.weightKg(),
                        item.pricePerKg(),
                        item.weightKg().multiply(item.pricePerKg())
                )
        ).toList();

    }
}
