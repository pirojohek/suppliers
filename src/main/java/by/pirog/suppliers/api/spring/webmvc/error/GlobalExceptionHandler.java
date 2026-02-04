package by.pirog.suppliers.api.spring.webmvc.error;

import by.pirog.suppliers.exception.ProductNotFoundException;
import by.pirog.suppliers.exception.SupplierNotFoundException;
import by.pirog.suppliers.exception.SupplyNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;

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
            SupplierNotFoundException ex,
            HttpServletRequest request) {
        return buildNotFoundProblem(ex, request, "Supplier Not Found");
    }

    @ExceptionHandler(SupplyNotFoundException.class)
    public ErrorResponseException handleSupplyNotFound(
            SupplyNotFoundException ex,
            HttpServletRequest request) {
        return buildNotFoundProblem(ex, request, "Supply Not Found");
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ErrorResponseException handleValidationErrors(Exception ex, HttpServletRequest request) {
        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Validation failed");
        problem.setDetail("Запрос содержит некорректные данные");
        problem.setInstance(URI.create(request.getRequestURI()));
        problem.setProperty("method", request.getMethod());
        problem.setProperty("errors", ValidationErrorExtractor.extractFieldErrors(ex));
        return new ErrorResponseException(HttpStatus.BAD_REQUEST, problem, ex);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ErrorResponseException handleConstraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Validation failed");
        problem.setDetail("Параметры запроса некорректны");
        problem.setInstance(URI.create(request.getRequestURI()));
        problem.setProperty("method", request.getMethod());
        problem.setProperty("errors", ValidationErrorExtractor.extractViolations(ex));
        return new ErrorResponseException(HttpStatus.BAD_REQUEST, problem, ex);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    public ErrorResponseException handleTypeMismatch(Exception ex, HttpServletRequest request) {
        var problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Invalid format");
        problem.setDetail("Неверный формат входных данных (например, дата или число)");
        problem.setInstance(URI.create(request.getRequestURI()));
        problem.setProperty("method", request.getMethod());
        return new ErrorResponseException(HttpStatus.BAD_REQUEST, problem, ex);
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
