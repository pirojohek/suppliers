package by.pirog.suppliers.mapper;

import by.pirog.suppliers.enums.ProductType;
import by.pirog.suppliers.storage.model.ProductEntity;
import by.pirog.suppliers.util.ProductUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductMapperTests {

    ProductMapper productMapper = Mappers.getMapper(ProductMapper.class);

    @Test
    @DisplayName("Test mapping ProductEntity to ProductData functionality")
    void givenProductEntity_whenMappingToProductData_thenResultIsCorrect(){
        // given
        var productEntity = ProductUtils.getProductEntityPersistent();

        // when
        var productData = productMapper.productEntityToProductData(productEntity);

        // then
        assertEquals(productEntity.getId(), productData.id());
        assertEquals(productEntity.getName(), productData.name());
        assertEquals(productEntity.getType(), productData.productType());
    }
}
