package by.pirog.suppliers.api.spring.webmvc;

import by.pirog.suppliers.api.AcceptSupplyApi;
import by.pirog.suppliers.data.supply.SupplyAcceptData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AcceptSupplyRestController.class)
public class AcceptSupplyRestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private AcceptSupplyApi acceptSupplyApi;

    @Test
    @DisplayName("Test accept supply functionality")
    void whenAcceptSupply_thenResultIsCreated() throws Exception {
        // given
        SupplyAcceptData data = SupplyAcceptData.builder()
                .supplierId(1L)
                .supplyDate(LocalDate.now())
                .build();
        Long response = 1L;

        when(acceptSupplyApi.acceptSupply(any(SupplyAcceptData.class)))
                .thenReturn(response);

        // when
        ResultActions result = mockMvc.perform(post("/api/accept-supply")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(data)));
        // then
        result.andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/supply/%d".formatted(response)))
                .andExpect(jsonPath("$.supplyId").value(response));
    }
}
