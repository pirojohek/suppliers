package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supplierPrice.CreateSupplierPriceRequestData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.mapper.SupplierPriceMapper;
import by.pirog.suppliers.spi.supplierPrice.SaveSupplierPriceSpi;
import by.pirog.suppliers.storage.model.ProductEntity;
import by.pirog.suppliers.storage.model.SupplierEntity;
import by.pirog.suppliers.storage.model.SupplierPriceEntity;
import by.pirog.suppliers.storage.repository.SupplierPriceRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaClientSaveSupplierPrice implements SaveSupplierPriceSpi {

    private final SupplierPriceRepository supplierPriceRepository;
    private final SupplierPriceMapper supplierPriceMapper;

    private final EntityManager entityManager;

    @Override
    public SupplierProductPriceData saveSupplierPrice(CreateSupplierPriceRequestData requestData) {
        SupplierEntity supplierRef = entityManager.getReference(SupplierEntity.class, requestData.supplierId());
        ProductEntity productRef = entityManager.getReference(ProductEntity.class, requestData.productId());

        var supplierPrice = SupplierPriceEntity.builder()
                .price(requestData.price())
                .supplier(supplierRef)
                .product(productRef)
                .dateFrom(requestData.dateFrom())
                .dateTo(requestData.dateTo())
                .build();
        this.supplierPriceRepository.save(supplierPrice);

        return supplierPriceMapper.supplierPriceEntityToSupplierPriceData(supplierPrice);
    }
}
