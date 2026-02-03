package by.pirog.suppliers.repository;

import by.pirog.suppliers.model.SupplyItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyItemRepository extends JpaRepository<SupplyItemEntity, Long> {
}
