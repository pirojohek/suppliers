package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplier.CreateSupplierRequestData;
import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.mapper.SupplierMapper;
import by.pirog.suppliers.spi.supplier.SaveSupplierSpi;
import by.pirog.suppliers.spi.supply.SaveSupplySpi;
import by.pirog.suppliers.storage.model.SupplierEntity;
import by.pirog.suppliers.storage.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaClientSaveSupplier implements SaveSupplierSpi {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    @Override
    public SupplierData createSupplier(CreateSupplierRequestData requestData) {
        SupplierEntity supplier = this.supplierMapper
                .createSupplierRequestToSupplierEntity(requestData);

        this.supplierRepository.save(supplier);

        return this.supplierMapper.supplierEntityToSupplierData(supplier);
    }
}
