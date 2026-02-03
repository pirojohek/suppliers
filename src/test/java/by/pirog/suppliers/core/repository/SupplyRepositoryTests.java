package by.pirog.suppliers.core.repository;

import by.pirog.suppliers.model.SupplierEntity;
import by.pirog.suppliers.model.SupplyEntity;
import by.pirog.suppliers.repository.SupplyRepository;
import by.pirog.suppliers.util.SupplierUtils;
import by.pirog.suppliers.util.SupplyUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class SupplyRepositoryTests {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private SupplyRepository supplyRepository;

    @Test
    @DisplayName("Test save supply entity functionality")
    void givenSupplyEntity_whenSave_thenEntityIsCreated() {
        // given
        SupplierEntity supplier = SupplierUtils.getSupplierEntityTransient();
        em.persist(supplier);
        em.flush();
        em.clear();

        SupplyEntity supply = SupplyUtils.getSupplyEntityTransient(supplier);
        // when
        var savingResult = supplyRepository.save(supply);

        // then
        assertNotNull(em.find(SupplyEntity.class, savingResult.getId()));
    }
}
