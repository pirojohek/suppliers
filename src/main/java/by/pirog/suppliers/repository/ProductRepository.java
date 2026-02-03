package by.pirog.suppliers.repository;

import by.pirog.suppliers.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
