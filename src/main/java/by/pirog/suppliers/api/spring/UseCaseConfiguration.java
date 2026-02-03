package by.pirog.suppliers.api.spring;

import by.pirog.suppliers.api.FindCurrentProductSupplierPriceApi;
import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.api.FindSupplierApi;
import by.pirog.suppliers.api.usecase.product.FindProductUseCase;
import by.pirog.suppliers.api.usecase.supplier.FindSupplierUseCase;
import by.pirog.suppliers.api.usecase.supplierPrice.FindCurrentProductSupplierPriceUseCase;
import by.pirog.suppliers.api.usecase.supply.AcceptSupplyUseCase;
import by.pirog.suppliers.spi.product.FindProductByIdSpi;
import by.pirog.suppliers.spi.supplier.FindSupplierByIdSpi;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductSupplierPriceSpi;
import by.pirog.suppliers.spi.supply.SaveSupplySpi;
import by.pirog.suppliers.spi.supplyItem.SaveSupplyItemsSpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public FindProductApi findProductApi(FindProductByIdSpi findProductByIdSpi) {
        return new FindProductUseCase(findProductByIdSpi);
    }

    @Bean
    public FindSupplierApi findSupplierApi(FindSupplierByIdSpi findSupplierByIdSpi) {
        return new FindSupplierUseCase(findSupplierByIdSpi);
    }

    @Bean
    public FindCurrentProductSupplierPriceApi findCurrentProductSupplierPriceApi(
            FindCurrentProductSupplierPriceSpi findCurrentProductSupplierPriceSpi
    ) {
        return new FindCurrentProductSupplierPriceUseCase(findCurrentProductSupplierPriceSpi);
    }

    @Bean
    public AcceptSupplyUseCase acceptSupplyUseCase(
            FindSupplierApi findSupplierApi,
            FindProductApi findProductApi,
            FindCurrentProductSupplierPriceApi findCurrentProductSupplierPriceApi,
            SaveSupplySpi saveSupplySpi, SaveSupplyItemsSpi saveSupplyItemsSpi) {
        return new AcceptSupplyUseCase(findSupplierApi, findProductApi, findCurrentProductSupplierPriceApi,
                saveSupplySpi, saveSupplyItemsSpi);
    }
}

