package by.pirog.suppliers.data.supplier;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
@Schema(name = "CreateSupplierRequest")
public record CreateSupplierRequestData(
        @Schema(description = "Название поставщика", example = "ООО Красная шапочка")
        @NotBlank(message = "name is required")
        String name
) {
}
