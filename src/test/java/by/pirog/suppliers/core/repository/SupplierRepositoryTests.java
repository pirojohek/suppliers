package by.pirog.suppliers.core.repository;

import by.pirog.suppliers.model.SupplierEntity;
import by.pirog.suppliers.repository.SupplierRepository;
import by.pirog.suppliers.util.SupplierUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class SupplierRepositoryTests {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    @DisplayName("Test save supplier functionality")
    void givenSupplier_whenSave_thenEntityIsCreated() {
        // given
        var entityToSave = SupplierUtils.getSupplierEntityTransient();

        // when
        var result = supplierRepository.save(entityToSave);

        // then
        assertNotNull(em.find(SupplierEntity.class, result.getId()));
    }
}
