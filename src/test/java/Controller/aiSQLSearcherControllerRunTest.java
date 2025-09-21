// java
package Controller;

import DTO.QueryResponseServiceDTO;
import Service.aiSQLSearcherAddService;
import Service.aiSQLSearcherGetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = aiSQLSearcherController.class)
class aiSQLSearcherControllerRunTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private aiSQLSearcherAddService addService;
    @MockitoBean
    private aiSQLSearcherGetService getService;

    @Test
    void testRun_success() throws Exception {
        QueryResponseServiceDTO mockResp = new QueryResponseServiceDTO();
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> row = new HashMap<>();
        row.put("foo", 1);
        data.add(row);
        mockResp.setData(data);
        mockResp.setError(null);

        when(addService.run(any())).thenReturn(mockResp);

        String body = "{\"sql\":\"select 1\"}";

        mockMvc.perform(post("/AiSQLSearcher/run")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].foo").value(1));
    }

    @Test
    void testRun_error() throws Exception {
        QueryResponseServiceDTO errResp = new QueryResponseServiceDTO();
        errResp.setData(null);
        errResp.setError("syntax error near 'from'");

        when(addService.run(any())).thenReturn(errResp);

        String body = "{\"sql\":\"select from\"}";

        mockMvc.perform(post("/AiSQLSearcher/run")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.error").value("syntax error near 'from'"));
    }
}
