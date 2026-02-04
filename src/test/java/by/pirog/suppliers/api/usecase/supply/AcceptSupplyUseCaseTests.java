package by.pirog.suppliers.api.usecase.supply;

import by.pirog.suppliers.api.FindCurrentProductSupplierPriceApi;
import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.api.FindSupplierApi;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.data.supplier.SupplierData;
import by.pirog.suppliers.data.supplierPrice.FindSupplierProductPriceData;
import by.pirog.suppliers.data.supplierPrice.SupplierProductPriceData;
import by.pirog.suppliers.data.supply.SupplyAcceptData;
import by.pirog.suppliers.data.supply.SupplyAcceptItemData;
import by.pirog.suppliers.data.supplyItem.CreateSupplyItemData;
import by.pirog.suppliers.enums.ProductType;
import by.pirog.suppliers.spi.supply.SaveSupplySpi;
import by.pirog.suppliers.spi.supplyItem.SaveSupplyItemsSpi;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AcceptSupplyUseCaseTests {

    @Mock
    private FindSupplierApi findSupplierApi;

    @Mock
    private FindProductApi findProductApi;

    @Mock
    private FindCurrentProductSupplierPriceApi findCurrentProductSupplierPriceApi;

    @Mock
    private SaveSupplySpi saveSupplySpi;

    @Mock
    private SaveSupplyItemsSpi saveSupplyItemsSpi;

    @InjectMocks
    private AcceptSupplyUseCase useCase;

    @Test
    @DisplayName("Accept supply saves supply and items with mapped prices")
    void givenAcceptData_whenAcceptSupply_thenSupplyAndItemsPersisted() {
        // given


    }
}
