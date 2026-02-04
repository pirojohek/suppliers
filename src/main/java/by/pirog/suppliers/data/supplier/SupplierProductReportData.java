package by.pirog.suppliers.data.supplier;

import by.pirog.suppliers.enums.ProductType;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SupplierProductReportData(
        Long supplierId,
        String supplierName,
        ProductType productType,
        BigDecimal totalWeight,
        BigDecimal totalCost
) {
}
