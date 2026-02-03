package by.pirog.suppliers.api.usecase.supply;

import by.pirog.suppliers.api.*;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.data.supply.CreateSupplyData;
import by.pirog.suppliers.data.supply.SupplyAcceptData;
import by.pirog.suppliers.spi.supply.SaveSupplySpi;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AcceptSupplyUseCase implements AcceptSupplyApi {

    private final FindSupplierApi findSupplierApi;
    private final FindProductApi findProductApi;
    private final FindCurrentProductSupplierPriceApi findCurrentProductSupplierPriceApi;
    private final SaveSupplySpi saveSupplySpi;

    @Override
    public Long acceptSupply(SupplyAcceptData data) {
        // Находим поставщика
        var supplier = this.findSupplierApi.findSupplierById(data.supplierId());

        // Находим все продукты, используется для проверки существования продуктов
        List<ProductData> productsData = data.items().stream()
                .map(item -> findProductApi.findProductById(item.productId()))
                .toList();

        // Проверяем, что поставщик продает такие товары
        List<SupplierProductPriceData> productPriceData = data.items().stream()
                .map(item -> findCurrentProductSupplierPriceApi
                        .findCurrentProductSupplierPrice(FindSupplierProductPriceData.builder()
                                .supplyDate(data.supplyDate())
                                .supplierId(supplier.id())
                                .productId(item.productId())
                                .build()))
                .toList();

        // Теперь надо создать supply
        Long supplyId = this.saveSupplySpi.saveSupply(CreateSupplyData.builder()
                        .supplyDate(data.supplyDate())
                        .supplierId(supplier.id())
                .build());

        // Далее создаю все supplyItem



        return null;
    }
}
