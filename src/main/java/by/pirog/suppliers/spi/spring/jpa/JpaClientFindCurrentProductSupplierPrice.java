package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.mapper.SupplierPriceMapper;
import by.pirog.suppliers.storage.repository.SupplierPriceRepository;
import by.pirog.suppliers.spi.supplierPrice.FindCurrentProductSupplierPriceSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaClientFindCurrentProductSupplierPrice implements FindCurrentProductSupplierPriceSpi {

    private final SupplierPriceRepository supplierPriceRepository;
    private final SupplierPriceMapper supplierPriceMapper;

    @Override
    public Optional<SupplierProductPriceData> findCurrentProductPrice(FindSupplierProductPriceData data) {
        var supplierPrice = this.supplierPriceRepository
                .findCurrentProductSupplierPrice(data.productId(), data.supplierId(), data.supplyDate());

        return supplierPrice.map(supplierPriceMapper::supplierPriceEntityToSupplierPriceData);
    }

}
