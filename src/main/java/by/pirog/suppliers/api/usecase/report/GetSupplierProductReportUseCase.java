package by.pirog.suppliers.api.usecase.report;

import by.pirog.suppliers.api.GetSupplierProductReportApi;
import by.pirog.suppliers.data.supplier.SupplierProductReportData;
import by.pirog.suppliers.spi.supplier.GetSupplierProductReportSpi;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
public class GetSupplierProductReportUseCase implements GetSupplierProductReportApi {

    private final GetSupplierProductReportSpi getSupplierProductReportSpi;

    @Override
    public List<SupplierProductReportData> getReport(LocalDate from, LocalDate to) {
        // todo - добавить проверку: to > from
        return this.getSupplierProductReportSpi.getReport(from, to);
    }
}
