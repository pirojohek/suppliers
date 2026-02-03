package by.pirog.suppliers.storage.repository;

import by.pirog.suppliers.storage.model.SupplierPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SupplierPriceRepository extends JpaRepository<SupplierPriceEntity, Long> {

    @Query("select sp from SupplierPriceEntity sp " +
            "where sp.supplier.id = :supplierId and " +
            "sp.dateFrom <= :supplyDate and sp.dateTo >= :supplyDate and " +
            "sp.product.id = :productId")
    Optional<SupplierPriceEntity> findCurrentProductSupplierPrice(Long productId, Long supplierId, LocalDate supplyDate);
}
