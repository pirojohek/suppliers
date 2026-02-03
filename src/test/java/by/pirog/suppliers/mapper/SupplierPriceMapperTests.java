package by.pirog.suppliers.mapper;

import by.pirog.suppliers.util.ProductUtils;
import by.pirog.suppliers.util.SupplierPriceUtils;
import by.pirog.suppliers.util.SupplierUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class SupplierPriceMapperTests {

    SupplierPriceMapper supplierPriceMapper = Mappers.getMapper(SupplierPriceMapper.class);

    @Test
    @DisplayName("Test mapping SupplierPriceEntity To SupplierPriceData functiioinality")
    void givenSupplierPriceEntity_whenMappingToSupplierPriceData_thenResultIsCorrect(){
        // given
        var supplier = SupplierUtils.getSupplierEntityPersistent();
        var product = ProductUtils.getProductEntityPersistent();
        var supplierPriceEntity = SupplierPriceUtils.getSupplierPricePersistent(supplier, product);

        // when
        var supplierPriceData = supplierPriceMapper.supplierPriceEntityToSupplierPriceData(supplierPriceEntity);

        // then
        assertEquals(supplierPriceEntity.getSupplier().getId(), supplierPriceData.supplierId());
        assertEquals(supplierPriceEntity.getPrice(), supplierPriceData.price());
        assertEquals(supplierPriceEntity.getId(), supplierPriceData.id());
        assertEquals(supplierPriceEntity.getProduct().getId(), supplierPriceData.productId());
        assertEquals(supplierPriceEntity.getDateFrom(), supplierPriceData.dateFrom());
        assertEquals(supplierPriceEntity.getDateTo(), supplierPriceData.dateTo());
    }
}
