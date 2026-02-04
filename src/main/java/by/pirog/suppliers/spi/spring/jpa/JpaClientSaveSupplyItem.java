package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplyItem.CreateSupplyItemData;
import by.pirog.suppliers.storage.model.SupplierPriceEntity;
import by.pirog.suppliers.storage.model.SupplyEntity;
import by.pirog.suppliers.storage.model.SupplyItemEntity;
import by.pirog.suppliers.storage.repository.SupplyItemRepository;
import by.pirog.suppliers.spi.supplyItem.SaveSupplyItemsSpi;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JpaClientSaveSupplyItem implements SaveSupplyItemsSpi {

    private final SupplyItemRepository supplyItemRepository;

    private final EntityManager entityManager;

    @Override
    public void saveSupplyItems(List<CreateSupplyItemData> data) {
        SupplyEntity supplyEntityRef = this.entityManager.getReference(SupplyEntity.class,
                data.getFirst().supplyId());
        SupplierPriceEntity supplierPriceEntity = this.entityManager
                .getReference(SupplierPriceEntity.class, data.getFirst().supplyPriceId());

        List<SupplyItemEntity> itemsEntity = data.stream().map(entity ->
                SupplyItemEntity.builder()
                        .supply(supplyEntityRef)
                        .weightPerKg(entity.weightPerKg())
                        .supplierPrice(supplierPriceEntity)
                        .build())
                .toList();
        supplyItemRepository.saveAll(itemsEntity);
    }
}
