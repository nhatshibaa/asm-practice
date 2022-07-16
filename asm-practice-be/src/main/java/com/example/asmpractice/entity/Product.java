package com.example.asmpractice.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;
    private String prodName;
    private String description;
    private String dateOfManf;
    private int price;

    public Product(String prodName, String description, String dateOfManf, int price) {
        this.prodName = prodName;
        this.description = description;
        this.dateOfManf = dateOfManf;
        this.price = price;
    }
}