package by.pirog.suppliers.core.repository;

import by.pirog.suppliers.model.ProductEntity;
import by.pirog.suppliers.model.SupplierEntity;
import by.pirog.suppliers.model.SupplierPriceEntity;
import by.pirog.suppliers.repository.SupplierPriceRepository;
import by.pirog.suppliers.util.ProductUtils;
import by.pirog.suppliers.util.SupplierPriceUtils;
import by.pirog.suppliers.util.SupplierUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class SupplierPriceRepositoryTests {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private SupplierPriceRepository supplierPriceRepository;

    @Test
    @DisplayName("Test save supplier price entity functionality")
    void givenSupplierPriceEntity_whenSave_thenEntityIsCreated(){
        // given
        SupplierEntity supplier = SupplierUtils.getSupplierEntityTransient();
        ProductEntity product = ProductUtils.getProductEntityTransient();
        em.persist(supplier);
        em.persist(product);
        em.flush();
        em.clear();

        SupplierPriceEntity supplierPriceToSave = SupplierPriceUtils
                .getSupplierPriceTransient(supplier, product);

        // when
        var savingResult = this.supplierPriceRepository.save(supplierPriceToSave);

        // then
        assertNotNull(em.find(SupplierPriceEntity.class, savingResult.getId()));
    }

}
