package by.pirog.suppliers.api.usecase.supply;

import by.pirog.suppliers.api.*;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.data.supply.CreateSupplyData;
import by.pirog.suppliers.data.supply.SupplyAcceptData;
import by.pirog.suppliers.data.supplyItem.CreateSupplyItemData;
import by.pirog.suppliers.exception.BadSupplyAcceptRequestException;
import by.pirog.suppliers.spi.supply.SaveSupplySpi;
import by.pirog.suppliers.spi.supplyItem.SaveSupplyItemsSpi;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AcceptSupplyUseCase implements AcceptSupplyApi {

    private final FindSupplierApi findSupplierApi;
    private final FindProductApi findProductApi;
    private final FindCurrentProductSupplierPriceApi findCurrentProductSupplierPriceApi;

    private final SaveSupplySpi saveSupplySpi;
    private final SaveSupplyItemsSpi saveSupplyItemsSpi;


    @Override
    public Long acceptSupply(SupplyAcceptData data) {
        if (data.items().isEmpty()) {
            throw new BadSupplyAcceptRequestException("Список не должен быть пустым");
        }

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

        Map<Long, SupplierProductPriceData> priceByProductId = productPriceData.stream()
                .collect(Collectors.toMap(SupplierProductPriceData::productId, Function.identity()));

        // Теперь надо создать supply
        Long supplyId = this.saveSupplySpi.saveSupply(CreateSupplyData.builder()
                .supplyDate(data.supplyDate())
                .supplierId(supplier.id())
                .build());

        List<CreateSupplyItemData> supplyItems = data.items().stream()
                .map(item -> CreateSupplyItemData.builder()
                        .supplyId(supplyId)
                        .supplyPriceId(priceByProductId.get(item.productId()).id())
                        .weightPerKg(item.weightPerKg())
                        .build())
                .toList();

        this.saveSupplyItemsSpi.saveSupplyItems(supplyItems);

        return supplyId;
    }
}
