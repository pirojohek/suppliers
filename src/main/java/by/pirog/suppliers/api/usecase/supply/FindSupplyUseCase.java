package by.pirog.suppliers.api.usecase.supply;

import by.pirog.suppliers.api.FindSupplyByIdApi;
import by.pirog.suppliers.data.supply.SupplyBaseData;
import by.pirog.suppliers.exception.SupplyNotFoundException;
import by.pirog.suppliers.spi.supply.FindSupplyByIdSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FindSupplyUseCase implements FindSupplyByIdApi {

    private final FindSupplyByIdSpi findSupplyByIdSpi;

    @Override
    public SupplyBaseData findSupply(Long supplyId) {
        return this.findSupplyByIdSpi.findById(supplyId)
                .orElseThrow(() -> new SupplyNotFoundException("Поставка с id: "+ supplyId + " не найдена"));
    }
}
