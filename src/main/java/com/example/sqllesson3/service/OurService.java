package com.example.sqllesson3.service;

import com.example.sqllesson3.repository.OurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OurService {
    OurRepository repository;

    public OurService(OurRepository repository) {
        this.repository = repository;
    }

    public List<String> getName(String name){
        return repository.getProductName(name);
    }
}
