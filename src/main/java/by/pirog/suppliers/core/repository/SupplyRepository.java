package by.pirog.suppliers.core.repository;

import by.pirog.suppliers.core.model.SupplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyRepository extends JpaRepository<SupplyEntity, Long> {
}
