package by.pirog.suppliers.api.usecase.supplierPrice;

import by.pirog.suppliers.api.FindCurrentProductPriceByProductIdApi;
import by.pirog.suppliers.api.FindCurrentProductSupplierPriceApi;
import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.exception.SupplierProductPriceNotFoundException;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductPriceByProductIdSpi;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductSupplierPriceSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class FindCurrentProductSupplierPriceUseCase implements FindCurrentProductSupplierPriceApi, FindCurrentProductPriceByProductIdApi {

    private final FindCurrentProductSupplierPriceSpi findCurrentProductSupplierPriceSpi;
    private final FindCurrentProductPriceByProductIdSpi findCurrentProductPriceByProductIdSpi;

    @Override
    public SupplierProductPriceData findCurrentProductSupplierPrice(FindSupplierProductPriceData data) {
        return this.findCurrentProductSupplierPriceSpi.findCurrentProductPrice(data)
                .orElseThrow(() -> new SupplierProductPriceNotFoundException("Поставщик не выставил цену в эту дату на товар"));
    }

    @Override
    public SupplierProductPriceData findCurrentProductPriceByProductId(Long productId, LocalDate date) {
        return this.findCurrentProductPriceByProductIdSpi.findCurrentProductPriceByProductId(productId, date)
                .orElseThrow(() -> new SupplierProductPriceNotFoundException("Поставщик не выставил цену в эту дату на товар"));
    }
}
