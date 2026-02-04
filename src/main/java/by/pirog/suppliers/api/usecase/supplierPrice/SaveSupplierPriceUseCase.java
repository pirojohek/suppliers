package by.pirog.suppliers.api.usecase.supplierPrice;

import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.api.FindSupplierApi;
import by.pirog.suppliers.api.SaveSupplierPriceApi;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.data.supplierPrice.CreateSupplierPriceRequestData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.exception.SupplierPriceOverlapException;
import by.pirog.suppliers.spi.supplierPrice.CheckSupplierPriceOverlapSpi;
import by.pirog.suppliers.spi.supplierPrice.SaveSupplierPriceSpi;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SaveSupplierPriceUseCase implements SaveSupplierPriceApi {

    private final SaveSupplierPriceSpi saveSupplierPriceSpi;
    private final FindProductApi findProductApi;
    private final FindSupplierApi findSupplierApi;
    private final CheckSupplierPriceOverlapSpi checkSupplierPriceOverlapSpi;

    @Override
    public SupplierProductPriceData createSupplierPrice(CreateSupplierPriceRequestData requestData) {
        // Проверяем, что поставщик существует
        SupplierData supplierData = this.findSupplierApi.findSupplierById(requestData.supplierId());

        // Проверяем, что продукт существует
        ProductData productData = this.findProductApi.findProductById(requestData.productId());

        // Проверяем пересечение времени
        boolean overlaps = this.checkSupplierPriceOverlapSpi.hasOverlappingPrice(
                requestData.supplierId(), requestData.productId(), requestData.dateFrom(), requestData.dateTo());

        if (overlaps){
            throw new SupplierPriceOverlapException(
                    "Цена для продукта %d у поставщика %d пересекается по датам"
                            .formatted(requestData.productId(), requestData.supplierId())
            );
        }

        return saveSupplierPriceSpi.saveSupplierPrice(requestData);
    }
}
