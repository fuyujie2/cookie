package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
@SpringBootApplication
@RestController
public class Application {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void Hello(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @GetMapping("/")
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/rowCount")
    public String getRowCount(@RequestParam(required = false,
            defaultValue = "default_table") String tableName) {
        String sql = String.format("SELECT COUNT(*) FROM %s",
                tableName);
        Integer rowCount = jdbcTemplate.queryForObject(sql,
                Integer.class);
        if (rowCount == null) {
            return "Row count: 0"; // 处理null情况
        }
        return "Row count: " + rowCount;
    }
}