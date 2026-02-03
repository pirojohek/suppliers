package by.pirog.suppliers.api.usecase.supplierPrice;

import by.pirog.suppliers.api.FindCurrentProductSupplierPriceApi;
import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.exception.SupplierProductPriceNotFoundException;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductSupplierPriceSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCurrentProductSupplierPriceUseCase implements FindCurrentProductSupplierPriceApi {

    private final FindCurrentProductSupplierPriceSpi findCurrentProductSupplierPriceSpi;

    @Override
    public SupplierProductPriceData findCurrentProductSupplierPrice(FindSupplierProductPriceData data) {
        return this.findCurrentProductSupplierPriceSpi.findCurrentProductPrice(data)
                .orElseThrow(() -> new SupplierProductPriceNotFoundException("Поставщик не выставил цену в эту дату на товар"));
    }
}
