package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.SaveSupplierApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.SupplierPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.SupplierPresentationV1;
import by.pirog.suppliers.api.usecase.supplier.SaveSupplierUseCase;
import by.pirog.suppliers.data.supplier.CreateSupplierRequestData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/supplier")
@RequiredArgsConstructor
public class SaveSupplierRestController {

    private final SaveSupplierApi saveSupplierApi;
    private final SupplierPresentationMapper supplierPresentationMapper;

    @PostMapping
    public ResponseEntity<SupplierPresentationV1> createSupplier(
            @RequestBody CreateSupplierRequestData requestData
    ) {
        var result = this.saveSupplierApi.createSupplier(requestData);
        var response = this.supplierPresentationMapper.supplierDataToSupplierPresentationV1(result);

        return ResponseEntity.created(URI.create("/api/supplier/%d".formatted(result.id())))
                .body(response);

    }
}
