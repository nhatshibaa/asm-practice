package com.example.asmpractice;

import com.example.asmpractice.entity.Product;
import com.example.asmpractice.entity.Sale;
import com.example.asmpractice.repo.ProductRepo;
import com.example.asmpractice.repo.SaleRepo;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {
    boolean createSeedData = false;
    final ProductRepo productRepo;
    final SaleRepo saleRepo;
    Faker faker;
    Random random = new Random();

    int numberOfSale = 100;

    public DataSeeder(ProductRepo productRepo, SaleRepo saleRepo) {
        this.productRepo = productRepo;
        this.saleRepo = saleRepo;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        if (createSeedData) {
            saleRepo.deleteAll();
            seedProduct();
            seedSale();
        }
    }

    private void seedProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Product-01", "Ngon", "01-12-2020", 100));
        products.add(new Product("Product-02", "Ngon lắm", "17-07-2010", 1090));
        products.add(new Product("Product-03", "Cực ngon", "28-01-2015", 8200));
        products.add(new Product("Product-04", "Ngon cực kì", "21-09-2018", 4400));
        products.add(new Product("Product-05", "Không ngon", "30-06-2022", 10000));
        productRepo.saveAll(products);
    }

    private void seedSale() {
        List<Sale> saleList = new ArrayList<>();
        List<Product> productList = productRepo.findAll();
        for (int i = 0; i < numberOfSale; i++) {
            Sale sale = new Sale();
            sale.setSalesmanId(faker.number().numberBetween(1, 10));
            sale.setDos(faker.name().name());
            sale.setProdId(productList.get(random.nextInt(productList.size())));
            sale.setSalesmanName(faker.name().fullName());
            saleList.add(sale);
        }
        saleRepo.saveAll(saleList);
    }
}
