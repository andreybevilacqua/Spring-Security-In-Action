package com.abevilacqua.ch6smallsecuredwebapp.entity;

import com.abevilacqua.ch6smallsecuredwebapp.model.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Product {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String price;

    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;
}
