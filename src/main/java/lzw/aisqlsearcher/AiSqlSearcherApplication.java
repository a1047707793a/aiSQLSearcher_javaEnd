package lzw.aisqlsearcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"lzw.aisqlsearcher", "Controller", "Service", "DTO"})
public class AiSqlSearcherApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiSqlSearcherApplication.class, args);
    }

}
