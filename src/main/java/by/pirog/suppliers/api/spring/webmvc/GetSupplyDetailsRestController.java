package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.GetSupplyDetailsApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.SupplyPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.SupplyDetailsPresentationV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supply")
public class GetSupplyDetailsRestController {

    private final GetSupplyDetailsApi getSupplyDetailsApi;
    private final SupplyPresentationMapper supplyPresentationMapper;

    @GetMapping("{id:\\d+}")
    public ResponseEntity<SupplyDetailsPresentationV1> getSupplyDetails(
            @PathVariable("id") Long supplyId
    ){
        var result = getSupplyDetailsApi.getSupplyDetails(supplyId);

        return ResponseEntity.ok(supplyPresentationMapper
                        .supplyDetailsToSupplyPresentationV1(result));
    }
}
