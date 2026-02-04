package by.pirog.suppliers.spi.spring.jpa;

import by.pirog.suppliers.data.supply.SupplyBaseData;
import by.pirog.suppliers.mapper.SupplyMapper;
import by.pirog.suppliers.spi.supply.FindSupplyByIdSpi;
import by.pirog.suppliers.storage.repository.SupplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaClientFindSupplyById implements FindSupplyByIdSpi {

    private final SupplyRepository supplyRepository;

    private final SupplyMapper supplyMapper;

    @Override
    public Optional<SupplyBaseData> findById(Long supplyId) {
        var supplyEntity = this.supplyRepository.findById(supplyId);

        return supplyEntity.map(supplyMapper::supplyEntityToSupplyBaseData);
    }
}
