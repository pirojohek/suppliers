package by.pirog.suppliers.data.supplierPrice;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record CreateSupplierPriceRequestData(
        Long productId,
        Long supplierId,
        BigDecimal price,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateFrom,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateTo
) {
}
