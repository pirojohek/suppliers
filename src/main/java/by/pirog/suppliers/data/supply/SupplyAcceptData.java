package by.pirog.suppliers.data.supply;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record SupplyAcceptData(
        Long supplierId,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate supplyDate,
        List<SupplyAcceptItemData> items
) {
}
