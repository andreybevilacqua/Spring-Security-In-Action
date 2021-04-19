package com.abevilacqua.ch6smallsecuredwebapp.entity;

import com.abevilacqua.ch6smallsecuredwebapp.model.EncryptionAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@Entity(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm algorithm;

    @OneToMany(mappedBy = "user", fetch = EAGER)
    private List<Authority> authorities;
}
