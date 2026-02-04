package by.pirog.suppliers.api;

import by.pirog.suppliers.data.supplier.SupplierProductReportData;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface GetSupplierProductReportApi {
    List<SupplierProductReportData> getReport(LocalDate from, LocalDate to);
}
