package com.example.asmpractice.service;

import com.example.asmpractice.entity.Product;
import com.example.asmpractice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
