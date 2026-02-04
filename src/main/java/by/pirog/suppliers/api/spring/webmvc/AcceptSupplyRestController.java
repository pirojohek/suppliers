package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.AcceptSupplyApi;
import by.pirog.suppliers.api.spring.webmvc.presentation.AcceptSupplyPresentationV1;
import by.pirog.suppliers.data.supply.SupplyAcceptData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/accept-supply")
@Tag(name = "Supply", description = "Операции приемки поставки")
public class AcceptSupplyRestController {

    private final AcceptSupplyApi acceptSupplyApi;

    @PostMapping
    @Operation(summary = "Принять поставку")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Поставка принята",
                    content = @Content(schema = @Schema(implementation = AcceptSupplyPresentationV1.class))),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    public ResponseEntity<AcceptSupplyPresentationV1> acceptSupply(
            @Valid @RequestBody SupplyAcceptData data
    ) {
        Long response = acceptSupplyApi.acceptSupply(data);

        return ResponseEntity.created(URI.create("/api/supply/%d".formatted(response)))
                .body(AcceptSupplyPresentationV1.builder()
                        .supplyId(response)
                        .build());
    }
}
