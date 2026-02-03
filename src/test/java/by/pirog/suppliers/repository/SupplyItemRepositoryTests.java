package by.pirog.suppliers.repository;

import by.pirog.suppliers.storage.model.*;
import by.pirog.suppliers.storage.repository.SupplyItemRepository;
import by.pirog.suppliers.util.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class SupplyItemRepositoryTests {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private SupplyItemRepository supplyItemRepository;

    @Test
    @DisplayName("Test save supply item entity functionality")
    void givenSupplyItemEntity_whenSave_thenEntityIsCreated(){
        // given
        SupplierEntity supplier = SupplierUtils.getSupplierEntityTransient();
        ProductEntity product = ProductUtils.getProductEntityTransient();
        em.persist(supplier);
        em.persist(product);
        em.flush();

        SupplierPriceEntity supplierPrice = SupplierPriceUtils
                .getSupplierPriceTransient(supplier, product);
        em.persist(supplierPrice);

        SupplyEntity supply = SupplyUtils.getSupplyEntityTransient(supplier);
        em.persist(supply);
        em.flush();

        SupplyItemEntity supplyItemToSave = SupplyItemUtils.getSupplyItemEntityTransient(supply, supplierPrice);
        // when
        var savingResult = supplyItemRepository.save(supplyItemToSave);

        // then
        assertNotNull(em.find(SupplyItemEntity.class, savingResult.getId()));
    }
}
