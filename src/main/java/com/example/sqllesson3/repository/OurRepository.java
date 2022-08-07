package com.example.sqllesson3.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OurRepository {
    private final JdbcTemplate jdbcTemplate;

    public OurRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> getProductName(String name) {
        String query= read("select_product_name.sql");
        List<String> listOfProducts=new ArrayList<>();

        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(query,name);

        while (sqlRowSet.next()) {
            listOfProducts.add(sqlRowSet.getString("product_name"));
        }
        return listOfProducts;
    }
}
