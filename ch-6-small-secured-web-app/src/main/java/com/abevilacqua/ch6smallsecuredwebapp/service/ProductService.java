package com.abevilacqua.ch6smallsecuredwebapp.service;

import com.abevilacqua.ch6smallsecuredwebapp.entity.Product;
import com.abevilacqua.ch6smallsecuredwebapp.repo.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findAll() {
        return productRepo.findAll();
    }
}
