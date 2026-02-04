package by.pirog.suppliers.mapper;

import by.pirog.suppliers.data.product.CreateProductRequestData;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.storage.model.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "type", target = "productType")
    ProductData productEntityToProductData(ProductEntity product);

    ProductEntity createProductRequestToProductEntity(CreateProductRequestData requestData);

}
