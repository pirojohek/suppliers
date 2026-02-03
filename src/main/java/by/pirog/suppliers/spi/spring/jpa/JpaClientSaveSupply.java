package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supply.CreateSupplyData;
import by.pirog.suppliers.model.SupplierEntity;
import by.pirog.suppliers.model.SupplyEntity;
import by.pirog.suppliers.repository.SupplyRepository;
import by.pirog.suppliers.spi.supply.SaveSupplySpi;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaClientSaveSupply implements SaveSupplySpi {

    private final SupplyRepository supplyRepository;

    private final EntityManager em;


    @Override
    public Long saveSupply(CreateSupplyData supplyData) {
        SupplierEntity supplier = em
                .getReference(SupplierEntity.class, supplyData.supplierId());

        var supply = SupplyEntity.builder()
                .supplyDate(supplyData.supplyDate())
                .supplier(supplier)
                .build();

        this.supplyRepository.save(supply);
        return supply.getId();
    }
}
