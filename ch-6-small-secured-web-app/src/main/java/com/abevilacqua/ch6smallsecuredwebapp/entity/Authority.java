package com.abevilacqua.ch6smallsecuredwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "authority")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Authority {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
}
