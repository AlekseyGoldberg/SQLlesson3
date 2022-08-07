package com.example.sqllesson3.controller;

import com.example.sqllesson3.service.OurService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OurController {
    OurService service;

    public OurController(OurService service) {
        this.service = service;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getName(@RequestParam String name) {
        return service.getName(name);
    }
}