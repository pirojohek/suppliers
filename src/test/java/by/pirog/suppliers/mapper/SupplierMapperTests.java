package by.pirog.suppliers.mapper;

import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.storage.model.SupplierEntity;
import by.pirog.suppliers.util.SupplierUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SupplierMapperTests {

    SupplierMapper supplierMapper = Mappers.getMapper(SupplierMapper.class);

    @Test
    @DisplayName("Test mapping SupplierEntity To SupplierData functionality")
    void givenSupplierEntity_whenMappingToSupplierData_thenResultIsCorrect(){
        // given
        var supplierToMapping = SupplierUtils.getSupplierEntityPersistent();

        // when
        var supplierData = supplierMapper.supplierEntityToSupplierData(supplierToMapping);

        // then
        assertEquals(supplierToMapping.getId(), supplierData.id());
        assertEquals(supplierToMapping.getName(), supplierData.name());
    }
}
