package by.pirog.suppliers.data.supplierPrice;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Schema(name = "CreateSupplierPriceRequest")
public record CreateSupplierPriceRequestData(
        @Schema(description = "ID товара", example = "1")
        @NotNull(message = "productId is required")
        Long productId,
        @Schema(description = "ID поставщика", example = "5")
        @NotNull(message = "supplierId is required")
        Long supplierId,
        @Schema(description = "Цена за кг", example = "12.50")
        @NotNull(message = "price is required")
        @DecimalMin(value = "0.0", inclusive = false, message = "price must be greater than 0")
        BigDecimal price,

        @Schema(description = "Дата начала действия", example = "2026-02-04")
        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull(message = "dateFrom is required")
        LocalDate dateFrom,

        @Schema(description = "Дата конца действия", example = "2026-02-18")
        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull(message = "dateTo is required")
        LocalDate dateTo
) {
}
