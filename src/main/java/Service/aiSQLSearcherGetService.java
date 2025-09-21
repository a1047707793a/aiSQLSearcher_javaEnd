package Service;

import DTO.HealthResponseServiceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class aiSQLSearcherGetService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = System.getenv().getOrDefault("AI_SQL_BASE_URL", "http://127.0.0.1:8000");

    // GET -> /health
    public HealthResponseServiceDTO health() {
        try {
            return restTemplate.getForObject(baseUrl + "/health", HealthResponseServiceDTO.class);
        } catch (Exception ex) {
            throw new RuntimeException("调用 FastAPI /health 失败: " + ex.getMessage(), ex);
        }
    }
}
