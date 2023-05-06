package ru.netology.jdbc_homework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class JdbcRepository {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    String sql;
    Map<String, String> param = new HashMap<>();

    public List<String> getProductName(String name) {
        param.put("name", name);
        sql = read("request.sql");
        var products = namedParameterJdbcTemplate.query(sql,
                param, (rs, rowNum) -> rs.getString("product_name"));
        return products;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
