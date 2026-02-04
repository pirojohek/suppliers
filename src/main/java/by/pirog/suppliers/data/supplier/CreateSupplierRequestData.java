package by.pirog.suppliers.data.supplier;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(name = "CreateSupplierRequest")
public record CreateSupplierRequestData(
        @Schema(description = "Название поставщика", example = "ООО Красная шапочка")
        String name
) {
}
