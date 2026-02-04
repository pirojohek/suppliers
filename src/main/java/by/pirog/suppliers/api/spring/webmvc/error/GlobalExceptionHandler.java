package by.pirog.suppliers.api.spring.webmvc.error;

import by.pirog.suppliers.exception.ProductNotFoundException;
import by.pirog.suppliers.exception.SupplierNotFoundException;
import by.pirog.suppliers.exception.SupplierProductPriceNotFoundException;
import by.pirog.suppliers.exception.SupplyNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponseException handleProductNotFound(
            ProductNotFoundException ex,
            HttpServletRequest request) {
        return buildNotFoundProblem(ex, request, "Product Not Found");
    }

    @ExceptionHandler(SupplierNotFoundException.class)
    public ErrorResponseException handleSupplierNotFound(
            ProductNotFoundException ex,
            HttpServletRequest request) {
        return buildNotFoundProblem(ex, request, "Supplier Not Found");
    }

    @ExceptionHandler(SupplierProductPriceNotFoundException.class)
    public ErrorResponseException handleSupplierPriceNotFound(
            SupplierProductPriceNotFoundException ex,
            HttpServletRequest request) {
        return buildNotFoundProblem(ex, request, "Supplier Product Price Not Found");
    }

    @ExceptionHandler(SupplyNotFoundException.class)
    public ErrorResponseException handleSupplyNotFound(
            SupplierProductPriceNotFoundException ex,
            HttpServletRequest request) {
        return buildNotFoundProblem(ex, request, "Supply Not Found");
    }

    private ErrorResponseException buildNotFoundProblem(
            RuntimeException ex,
            HttpServletRequest request,
            String title) {

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problemDetail.setTitle(title);
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setInstance(URI.create(request.getRequestURI()));
        problemDetail.setProperty("method", request.getMethod());

        return new ErrorResponseException(HttpStatus.NOT_FOUND, problemDetail, ex);
    }
}
