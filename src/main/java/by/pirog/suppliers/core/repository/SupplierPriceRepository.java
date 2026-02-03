package by.pirog.suppliers.core.repository;

import by.pirog.suppliers.core.model.SupplierPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierPriceRepository extends JpaRepository<SupplierPriceEntity, Long> {
}
