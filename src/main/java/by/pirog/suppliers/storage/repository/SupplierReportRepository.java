package by.pirog.suppliers.storage.repository;

import by.pirog.suppliers.data.supplier.SupplierProductReportData;

import java.time.LocalDate;
import java.util.List;

public interface SupplierReportRepository {
    List<SupplierProductReportData> getSupplierProductReport(
            LocalDate from,
            LocalDate to
    );
}
