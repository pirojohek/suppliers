package by.pirog.suppliers.core.repository;

import by.pirog.suppliers.core.model.SupplyItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyItemRepository extends JpaRepository<SupplyItemEntity, Long> {
}
