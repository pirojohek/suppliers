package by.pirog.suppliers.spi.supplier;

import by.pirog.suppliers.data.supplier.SupplierData;

import java.util.Optional;

@FunctionalInterface
public interface FindSupplierByIdSpi {

    Optional<SupplierData> findSupplierById(Long id);
}
