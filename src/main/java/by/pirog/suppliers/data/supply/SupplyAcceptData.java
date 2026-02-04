package by.pirog.suppliers.data.supply;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
@Schema(name = "SupplyAcceptRequest")
public record SupplyAcceptData(
        @Schema(description = "Id Поставщика", example = "1")
        @NotNull(message = "supplierId is required")
        Long supplierId,

        @Schema(description = "Дата поставки", example = "2026-02-04")
        @JsonFormat(pattern = "yyyy-MM-dd")
        @NotNull(message = "supplyDate is required")
        LocalDate supplyDate,

        @Schema(description = "Товары поставки")
        @NotEmpty(message = "items must not be empty")
        List<@Valid SupplyAcceptItemData> items
) {
}
