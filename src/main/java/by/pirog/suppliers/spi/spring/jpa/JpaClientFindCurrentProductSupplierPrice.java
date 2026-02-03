package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.repository.SupplierPriceRepository;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductPriceByProductIdSpi;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductSupplierPriceSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaClientFindCurrentProductSupplierPrice implements FindCurrentProductSupplierPriceSpi, FindCurrentProductPriceByProductIdSpi {

    private final SupplierPriceRepository supplierPriceRepository;

    @Override
    public Optional<SupplierProductPriceData> findCurrentProductPrice(FindSupplierProductPriceData data) {
        var supplierPrice = this.supplierPriceRepository
                .findCurrentProductSupplierPrice(data.productId(), data.supplierId(), data.supplyDate());

        return supplierPrice.map(sp ->
                SupplierProductPriceData.builder()
                        .price(sp.getPrice())
                        .productId(sp.getProduct().getId())
                        .dateFrom(sp.getDateFrom())
                        .dateTo(sp.getDateTo())
                        .supplierId(sp.getSupplier().getId())
                        .id(sp.getId())
                        .build());
    }

    @Override
    public Optional<SupplierProductPriceData> findCurrentProductPriceByProductId(Long productId, LocalDate date) {
        var supplierPrice = this.supplierPriceRepository
                .findCurrentProductSupplierPriceByProductId(productId, date);

        return supplierPrice.map(sp ->
                SupplierProductPriceData.builder()
                        .price(sp.getPrice())
                        .productId(sp.getProduct().getId())
                        .dateFrom(sp.getDateFrom())
                        .dateTo(sp.getDateTo())
                        .supplierId(sp.getSupplier().getId())
                        .id(sp.getId())
                        .build());
    }
}
