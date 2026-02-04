package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.GetSupplyDetailsApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.SupplyPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.SupplyDetailsPresentationV1;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supply")
@Tag(name = "Supply", description = "Получить информацию о поставке")
public class GetSupplyDetailsRestController {

    private final GetSupplyDetailsApi getSupplyDetailsApi;
    private final SupplyPresentationMapper supplyPresentationMapper;

    @GetMapping("{id:\\d+}")
    @Operation(summary = "Получить информацию о поставке по Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Детали поставки",
                    content = @Content(schema = @Schema(implementation = SupplyDetailsPresentationV1.class))),
            @ApiResponse(responseCode = "400", description = "Некорректный запрос",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "404", description = "Поставка не найдена", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    public ResponseEntity<SupplyDetailsPresentationV1> getSupplyDetails(
            @PathVariable("id") Long supplyId
    ){
        var result = getSupplyDetailsApi.getSupplyDetails(supplyId);

        return ResponseEntity.ok(supplyPresentationMapper
                        .supplyDetailsToSupplyPresentationV1(result));
    }
}
