package DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryRequestServiceDTO {
    private String question;
    private Boolean run; // 可选，query接口用
}
