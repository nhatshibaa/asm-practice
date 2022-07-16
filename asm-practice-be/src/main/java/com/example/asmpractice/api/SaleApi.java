package com.example.asmpractice.api;

import com.example.asmpractice.entity.Product;
import com.example.asmpractice.entity.Sale;
import com.example.asmpractice.service.ProductService;
import com.example.asmpractice.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/sales")
@CrossOrigin(origins = "*")
public class SaleApi {
    @Autowired
    SaleService saleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Sale> findAll(){
        return saleService.findAll();
    }
}
