package by.pirog.suppliers.api.spring.webmvc.mapper;

import by.pirog.suppliers.api.spring.webmvc.presentation.ProductPresentationV1;
import by.pirog.suppliers.data.product.ProductData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductPresentationMapper {

    @Mapping(source = "productType", target = "type")
    ProductPresentationV1 productDataToProductPresentationV1(ProductData data);
}
