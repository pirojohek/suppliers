package by.pirog.suppliers.storage.repository;

import by.pirog.suppliers.storage.model.SupplyItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyItemRepository extends JpaRepository<SupplyItemEntity, Long> {

    @Query("select sp from SupplyItemEntity sp " +
            "join fetch sp.supplierPrice " +
            "join fetch sp.supply " +
            "join fetch sp.supplierPrice.product " +
            "where sp.supply.id = :supplyId")
    List<SupplyItemEntity> findSupplyItemEntitiesBySupplyId(Long supplyId);
}
