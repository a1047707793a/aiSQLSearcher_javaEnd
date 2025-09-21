package DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class fastAPIResponseServiceDTO {
    private List<Map<String, Object>> data;
    private String error;
}
