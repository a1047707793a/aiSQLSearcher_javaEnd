package Controller;

import DTO.HealthResponseServiceDTO;
import DTO.QueryRequestServiceDTO;
import DTO.QueryResponseServiceDTO;
import Service.aiSQLSearcherAddService;
import Service.aiSQLSearcherGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AiSQLSearcher")
public class aiSQLSearcherController {

    @Autowired
    private aiSQLSearcherAddService addService;
    @Autowired
    private aiSQLSearcherGetService getService;

    //请求体：{"question": "你的问题", "run": true/false}，假如python端是debug模式则你的问题输入什么都会默认显示最新的前20条语句
    @PostMapping("/query")
    public QueryResponseServiceDTO query(@RequestBody QueryRequestServiceDTO request) {
        return addService.query(request);
    }

    //请求体：{"question": "你的问题", "run": true/false}，假如python端是debug模式则你的问题输入什么都会默认显示最新的前20条语句
    @PostMapping("/run")
    public QueryResponseServiceDTO run(@RequestBody QueryRequestServiceDTO request) {
        return addService.run(request);
    }

    // 保留：GET /health -> FastAPI /health
    @GetMapping("/health")
    public HealthResponseServiceDTO health() {
        return getService.health();
    }
}
