package by.pirog.suppliers.data.supplier;

import lombok.Builder;

@Builder
public record CreateSupplierRequestData(
        String name
) {
}
