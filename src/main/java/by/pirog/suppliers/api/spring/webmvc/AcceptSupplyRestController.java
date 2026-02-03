package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.AcceptSupplyApi;
import by.pirog.suppliers.api.spring.webmvc.presentation.AcceptSupplyPresentationV1;
import by.pirog.suppliers.data.supply.SupplyAcceptData;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/accept-supply")
public class AcceptSupplyRestController {

    private final AcceptSupplyApi acceptSupplyApi;

    @PostMapping
    public ResponseEntity<AcceptSupplyPresentationV1> acceptSupply(
            SupplyAcceptData data
    ) {
        Long response = acceptSupplyApi.acceptSupply(data);
        return ResponseEntity.ok(AcceptSupplyPresentationV1.builder()
                .supplyId(response)
                .build());
    }
}
