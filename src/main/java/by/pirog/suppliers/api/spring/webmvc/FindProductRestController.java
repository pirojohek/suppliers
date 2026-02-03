package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.api.spring.webmvc.presentation.ProductPresentationV1;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/product")
public class FindProductRestController {

    private final FindProductApi findProductApi;

    @GetMapping("{id:\\d+}")
    public ResponseEntity<ProductPresentationV1> findProduct(
            @PathVariable("id") Long id
    ){
        var result = this.findProductApi.findProductById(id);
        return ResponseEntity.ok(ProductPresentationV1.builder()
                .id(result.id())
                .name(result.name())
                .type(result.productType())
                .build());
    }
}
