package by.pirog.suppliers.data.supply;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
@Schema(name = "SupplyAcceptRequest")
public record SupplyAcceptData(
        @Schema(description = "Id Поставщика", example = "1")
        Long supplierId,

        @Schema(description = "Дата поставки", example = "2024-12-01")
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate supplyDate,

        @Schema(description = "Товары поставки")
        List<SupplyAcceptItemData> items
) {
}
