package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplyItem.SupplyItemBaseData;
import by.pirog.suppliers.mapper.ProductMapper;
import by.pirog.suppliers.spi.supplyItem.FindSupplyItemsBySupplyIdSpi;
import by.pirog.suppliers.storage.model.SupplyItemEntity;
import by.pirog.suppliers.storage.repository.SupplyItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaClientFindSupplyItemsBySupplyId implements FindSupplyItemsBySupplyIdSpi {

    private final SupplyItemRepository supplyItemRepository;
    private final ProductMapper productMapper;

    @Override
    public List<SupplyItemBaseData> findSupplyItems(Long supplyId) {
        List<SupplyItemEntity> supplyItems = this.supplyItemRepository
                .findSupplyItemEntitiesBySupplyId(supplyId);

        return supplyItems.stream().map(entity ->
                SupplyItemBaseData.builder()
                        .productData(productMapper.productEntityToProductData(entity.getSupplierPrice().getProduct()))
                        .pricePerKg(entity.getSupplierPrice().getPrice())
                        .weightKg(entity.getWeightPerKg())
                        .build())
                .toList();
    }
}
