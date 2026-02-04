package by.pirog.suppliers.spi.supplier;

import by.pirog.suppliers.data.supplier.SupplierProductReportData;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface GetSupplierProductReportSpi {
    List<SupplierProductReportData> getReport(LocalDate from, LocalDate to);
}
