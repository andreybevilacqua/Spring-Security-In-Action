package com.abevilacqua.ch6smallsecuredwebapp.repo;

import com.abevilacqua.ch6smallsecuredwebapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
