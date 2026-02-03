package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.util.ProductUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductPresentationMapperTests {

    ProductPresentationMapper mapper = Mappers.getMapper(ProductPresentationMapper.class);

    @Test
    @DisplayName("Test mapping ProductData To ProductPresentationV1 functionality")
    void givenProductData_whenMappingToProductPresentationV1_thenResultIsSuccess(){
        // given
        var productData = ProductUtils.getProductData();

        // when
        var productPresentationV1 = mapper.productDataToProductPresentationV1(productData);

        // then
        assertEquals(productData.id(), productPresentationV1.id());
        assertEquals(productData.productType(), productPresentationV1.type());
        assertEquals(productData.name(), productPresentationV1.name());
    }
}
