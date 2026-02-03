package by.pirog.suppliers.data.supplier;

import lombok.Builder;

@Builder
public record SupplierData(
        Long id,
        String name
) {
}
