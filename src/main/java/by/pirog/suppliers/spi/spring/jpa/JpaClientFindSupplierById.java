package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.mapper.SupplierMapper;
import by.pirog.suppliers.storage.model.SupplierEntity;
import by.pirog.suppliers.storage.repository.SupplierRepository;
import by.pirog.suppliers.spi.supplier.FindSupplierByIdSpi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaClientFindSupplierById implements FindSupplierByIdSpi {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public Optional<SupplierData> findSupplierById(Long id) {
        Optional<SupplierEntity> entity = this.supplierRepository.findById(id);
        return entity.map(supplierMapper::supplierEntityToSupplierData);
    }
}
