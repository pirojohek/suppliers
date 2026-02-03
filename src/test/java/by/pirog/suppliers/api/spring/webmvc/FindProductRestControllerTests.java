package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.FindProductApi;
import by.pirog.suppliers.api.spring.webmvc.mapper.ProductPresentationMapper;
import by.pirog.suppliers.api.spring.webmvc.presentation.ProductPresentationV1;
import by.pirog.suppliers.data.product.ProductData;
import by.pirog.suppliers.util.ProductPresentationUtil;
import by.pirog.suppliers.util.ProductUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(FindProductRestController.class)
public class FindProductRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private FindProductApi findProductApi;

    @MockitoBean
    private ProductPresentationMapper mapper;

    @Test
    @DisplayName("Test find product by id functionality")
    void findProduct_shouldReturnProductData() throws Exception{
        // given
        Long id = 1L;
        ProductData productData = ProductUtils.getProductData();
        ProductPresentationV1 productPresentation = ProductPresentationUtil.getProductPresentationV1();

        when(findProductApi.findProductById(anyLong()))
                .thenReturn(productData);
        when(mapper.productDataToProductPresentationV1(any(ProductData.class)))
                .thenReturn(productPresentation);

        // when
        ResultActions resultActions = mockMvc.perform(get("/api/product/%d".formatted(id)));

        // then
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(productPresentation.id()))
                .andExpect(jsonPath("$.name").value(productPresentation.name()))
                .andExpect(jsonPath("$.type").value(productPresentation.type().toString()));
    }
}
