// 文件: 'src/main/java/Controller/Application.java'
package Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"Controller", "Service"})
public class Application {
    public static void main(String[] args) {
        System.out.println("[AiSQLSearcher] 应用启动中，静态测试页: http://localhost:8080/aisql.html");
        SpringApplication.run(Application.class, args);
    }
}
