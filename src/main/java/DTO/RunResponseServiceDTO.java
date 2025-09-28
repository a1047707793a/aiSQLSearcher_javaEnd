package DTO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class RunResponseServiceDTO implements Serializable {
    private List<Map<String, Object>> data;
    private String error;

    public List<Map<String, Object>> getData() {
        return data;
    }

    public void setData(List<Map<String, Object>> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
