package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplier.SupplierProductReportData;
import by.pirog.suppliers.spi.supplier.GetSupplierProductReportSpi;
import by.pirog.suppliers.storage.repository.SupplierReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaClientSupplierProductReport implements GetSupplierProductReportSpi {

    private final SupplierReportRepository repository;

    @Override
    public List<SupplierProductReportData> getReport(LocalDate from, LocalDate to) {
        return this.repository.getSupplierProductReport(from, to);
    }
}
