package com.example.asmpractice.service;

import com.example.asmpractice.entity.Product;
import com.example.asmpractice.entity.Sale;
import com.example.asmpractice.repo.ProductRepo;
import com.example.asmpractice.repo.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    SaleRepo saleRepo;

    public List<Sale> findAll() {
        return saleRepo.findAll();
    }
}
