package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.mapper.SupplierPriceMapper;
import by.pirog.suppliers.spi.supplierPrice.FindAllSupplierPriceForProductSpi;
import by.pirog.suppliers.storage.repository.SupplierPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaClientFindAllSupplierPriceForProduct implements FindAllSupplierPriceForProductSpi {

    private final SupplierPriceRepository supplierPriceRepository;
    private final SupplierPriceMapper supplierPriceMapper;

    @Override
    public List<SupplierProductPriceData> findAll(Long productId, LocalDate date) {
        var result = this.supplierPriceRepository.findSupplierPriceEntityByProductId(productId, date);

        return result.stream().map(supplierPriceMapper::supplierPriceEntityToSupplierPriceData)
                .toList();
    }
}
