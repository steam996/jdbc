package ru.netology.jdbc_homework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jdbc_homework.repository.JdbcRepository;

import java.util.List;

@RestController
public class DBController {
    @Autowired
    private JdbcRepository repository;

    @GetMapping("/products/fetch-product")
    public List<String> getProductName (@RequestParam String name){
        return repository.getProductName(name);
    }
}
