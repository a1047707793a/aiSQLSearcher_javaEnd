package DTO;

import java.io.Serializable;

public class RunRequestServiceDTO implements Serializable {
    private String sql;

    public RunRequestServiceDTO() {
    }

    public RunRequestServiceDTO(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
