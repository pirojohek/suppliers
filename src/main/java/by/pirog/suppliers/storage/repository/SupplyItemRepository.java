package by.pirog.suppliers.storage.repository;

import by.pirog.suppliers.storage.model.SupplyItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyItemRepository extends JpaRepository<SupplyItemEntity, Long> {
}
