package com.example.asmpractice.entity;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int slNo;
    private int salesmanId;
    @ManyToOne
    @JoinColumn(name = "prodId", referencedColumnName = "prodId")
    private Product prodId;
    private String salesmanName;
    private String dos;
}