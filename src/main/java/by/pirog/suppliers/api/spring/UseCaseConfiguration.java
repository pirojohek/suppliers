package by.pirog.suppliers.api.spring;

import by.pirog.suppliers.api.*;
import by.pirog.suppliers.api.usecase.product.FindAllProductsWithPricesUseCase;
import by.pirog.suppliers.api.usecase.product.FindProductUseCase;
import by.pirog.suppliers.api.usecase.product.SaveProductUseCase;
import by.pirog.suppliers.api.usecase.supplier.FindSupplierUseCase;
import by.pirog.suppliers.api.usecase.supplier.SaveSupplierUseCase;
import by.pirog.suppliers.api.usecase.supplierPrice.FindCurrentProductSupplierPriceUseCase;
import by.pirog.suppliers.api.usecase.supplierPrice.SaveSupplierPriceUseCase;
import by.pirog.suppliers.api.usecase.supply.AcceptSupplyUseCase;
import by.pirog.suppliers.api.usecase.supply.FindSupplyUseCase;
import by.pirog.suppliers.api.usecase.supply.GetSupplyDetailsUseCase;
import by.pirog.suppliers.api.usecase.supplyItem.FindSupplyItemUseCase;
import by.pirog.suppliers.spi.product.FindAllProductsSpi;
import by.pirog.suppliers.spi.product.FindProductByIdSpi;
import by.pirog.suppliers.spi.product.SaveProductSpi;
import by.pirog.suppliers.spi.supplier.FindSupplierByIdSpi;
import by.pirog.suppliers.spi.supplier.SaveSupplierSpi;
import by.pirog.suppliers.spi.supplierPrice.CheckSupplierPriceOverlapSpi;
import by.pirog.suppliers.spi.supplierPrice.FindAllSupplierPriceForProductSpi;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductSupplierPriceSpi;
import by.pirog.suppliers.spi.supplierPrice.SaveSupplierPriceSpi;
import by.pirog.suppliers.spi.supply.FindSupplyByIdSpi;
import by.pirog.suppliers.spi.supply.SaveSupplySpi;
import by.pirog.suppliers.spi.supplyItem.FindSupplyItemsBySupplyIdSpi;
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

    @Bean
    public FindSupplyUseCase findSupplyUseCase(
            FindSupplyByIdSpi findSupplyByIdSpi
    ) {
        return new FindSupplyUseCase(findSupplyByIdSpi);
    }

    @Bean
    public FindSupplyItemsBySupplyIdApi findSupplyItemsBySupplyIdApi(
            FindSupplyItemsBySupplyIdSpi findSupplyItemsBySupplyIdSpi
    ) {
        return new FindSupplyItemUseCase(findSupplyItemsBySupplyIdSpi);
    }

    @Bean
    public GetSupplyDetailsUseCase getSupplyDetailsUseCase(
            FindSupplyByIdApi findSupplyByIdApi,
            FindSupplyItemsBySupplyIdApi findSupplyItemsBySupplyIdApi,
            FindSupplierApi findSupplierApi
    ) {
        return new GetSupplyDetailsUseCase(findSupplyItemsBySupplyIdApi, findSupplyByIdApi, findSupplierApi);
    }

    @Bean
    public SaveSupplierUseCase saveSupplierUseCase(SaveSupplierSpi saveSupplierSpi) {
        return new SaveSupplierUseCase(saveSupplierSpi);
    }

    @Bean
    public SaveProductUseCase saveProductUseCase(SaveProductSpi saveProductSpi) {
        return new SaveProductUseCase(saveProductSpi);
    }

    @Bean
    public SaveSupplierPriceUseCase saveSupplierPriceUseCase(
            SaveSupplierPriceSpi saveSupplierPriceSpi,
            FindProductApi findProductApi,
            FindSupplierApi findSupplierApi,
            CheckSupplierPriceOverlapSpi checkSupplierPriceOverlapSpi) {
        return new SaveSupplierPriceUseCase(saveSupplierPriceSpi, findProductApi, findSupplierApi, checkSupplierPriceOverlapSpi);
    }

    @Bean
    public FindAllProductsWithPricesInDateApi findAllProductsWithPricesInDateApi(
            FindAllProductsSpi findAllProductsSpi,
            FindAllSupplierPriceForProductSpi findAllSupplierPriceForProductSpi
            ) {
        return new FindAllProductsWithPricesUseCase(findAllProductsSpi, findAllSupplierPriceForProductSpi);
    }
}


