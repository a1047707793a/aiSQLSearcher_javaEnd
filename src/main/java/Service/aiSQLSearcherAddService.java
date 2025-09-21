package Service;

import DTO.QueryRequestServiceDTO;
import DTO.QueryResponseServiceDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class aiSQLSearcherAddService {

    private final RestTemplate restTemplate = new RestTemplate();
    // 可用环境变量 AI_SQL_BASE_URL 覆盖，默认本地 FastAPI
    private final String baseUrl = System.getenv().getOrDefault("AI_SQL_BASE_URL", "http://127.0.0.1:8000");

    // 替换：POST -> /api/sql/query（整合 ask 与 ask-run）
    public QueryResponseServiceDTO query(QueryRequestServiceDTO request) {
        try {
            return restTemplate.postForObject(baseUrl + "/api/sql/query", request, QueryResponseServiceDTO.class);
        } catch (Exception ex) {
            throw new RuntimeException("调用 FastAPI /api/sql/query 失败: " + ex.getMessage(), ex);
        }
    }

    // POST -> /api/sql/run
    public QueryResponseServiceDTO run(QueryRequestServiceDTO request) {
        try {
            return restTemplate.postForObject(baseUrl + "/api/sql/query", request, QueryResponseServiceDTO.class);
        } catch (Exception ex) {
            throw new RuntimeException("调用 FastAPI /api/sql/query 失败: " + ex.getMessage(), ex);
        }
    }
}
