package by.pirog.suppliers.storage.repository;

import by.pirog.suppliers.data.supplier.SupplierProductReportData;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SupplierReportRepositoryImpl implements SupplierReportRepository {

    private final EntityManager em;

    @Override
    public List<SupplierProductReportData> getSupplierProductReport(
            LocalDate from,
            LocalDate to
    ) {

        return em.createQuery("""
                            SELECT new by.pirog.suppliers.data.supplier.SupplierProductReportData(
                                s.id,
                                s.name,
                                p.type,
                                SUM(si.weightPerKg),
                                SUM(si.weightPerKg * spp.price)
                            )
                            FROM SupplyEntity sup
                            JOIN sup.supplier s
                            JOIN SupplyItemEntity si
                                ON si.supply = sup
                            JOIN si.supplierPrice spp
                            JOIN spp.product p
                            WHERE sup.supplyDate BETWEEN :from AND :to
                            GROUP BY s.id, s.name, p.type
                            ORDER BY s.name, p.type
                        """, SupplierProductReportData.class)
                .setParameter("from", from)
                .setParameter("to", to)
                .getResultList();
    }
}