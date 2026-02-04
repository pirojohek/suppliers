package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.spi.supplierPrice.CheckSupplierPriceOverlapSpi;
import by.pirog.suppliers.storage.repository.SupplierPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class JpaCheckSupplierPriceOverlap implements CheckSupplierPriceOverlapSpi {

    private final SupplierPriceRepository repository;

    @Override
    public boolean hasOverlappingPrice(
            Long supplierId,
            Long productId,
            LocalDate dateFrom,
            LocalDate dateTo
    ) {
        return repository.existsOverlappingPrice(
                supplierId,
                productId,
                dateFrom,
                dateTo
        );
    }
}
