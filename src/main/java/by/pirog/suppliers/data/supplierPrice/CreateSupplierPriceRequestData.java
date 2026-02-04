package by.pirog.suppliers.data.supplierPrice;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Schema(name = "CreateSupplierPriceRequest")
public record CreateSupplierPriceRequestData(
        @Schema(description = "ID товара", example = "1")
        Long productId,
        @Schema(description = "ID поставщика", example = "5")
        Long supplierId,
        @Schema(description = "Цена за кг", example = "12.50")
        BigDecimal price,

        @Schema(description = "Дата начала действия", example = "2026-02-04")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateFrom,

        @Schema(description = "Дата конца действия", example = "2026-02-18")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateTo
) {
}
