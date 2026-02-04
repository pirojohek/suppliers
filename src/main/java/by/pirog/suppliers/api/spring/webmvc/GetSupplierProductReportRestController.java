package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.GetSupplierProductReportApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.SupplierProductReportPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.SupplierProductReportPresentationV1;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/report/supplier-product")
@Tag(name = "Report", description = "Получить отчет по товарам и поставщикам")
public class GetSupplierProductReportRestController {

    private final GetSupplierProductReportApi getSupplierProductReportApi;
    private final SupplierProductReportPresentationMapper mapper;

    @GetMapping
    @Operation(summary = "Получить отчет по товарам и поставщикам",
            description = "Возвращает агрегированный отчет по товарам и поставщикам за указанный период")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Отчет сформирован",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = SupplierProductReportPresentationV1.class))),
            @ApiResponse(responseCode = "400", description = "Некорректные параметры запроса", content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера", content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    public ResponseEntity<List<SupplierProductReportPresentationV1>> getReport(
            @Parameter(description = "Дата начала периода", example = "2026-02-01", required = true)
            @RequestParam("from") LocalDate from,
            @Parameter(description = "Дата окончания периода", example = "2026-02-28", required = true)
            @RequestParam("to") LocalDate to
    ) {
        var report = this.getSupplierProductReportApi.getReport(from, to);
        return ResponseEntity.ok(report.stream()
                .map(mapper::supplierProductReportDataToPresentation)
                .toList());
    }
}
