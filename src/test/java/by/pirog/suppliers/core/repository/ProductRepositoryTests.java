package by.pirog.suppliers.core.repository;

import by.pirog.suppliers.core.model.ProductEntity;
import by.pirog.suppliers.util.ProductUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("Test save product functionality")
    void givenProduct_whenSave_thenProductIsCreated() {
        // given
        ProductEntity product = ProductUtils.getProductEntityTransient();

        // when
        var result = this.productRepository.save(product);

        // then
        assertNotNull(this.em.find(ProductEntity.class, result.getId()));
    }
}
