package com.abevilacqua.ch6smallsecuredwebapp;

import com.abevilacqua.ch6smallsecuredwebapp.entity.Authority;
import com.abevilacqua.ch6smallsecuredwebapp.entity.Product;
import com.abevilacqua.ch6smallsecuredwebapp.entity.User;
import com.abevilacqua.ch6smallsecuredwebapp.repo.AuthorityRepository;
import com.abevilacqua.ch6smallsecuredwebapp.repo.ProductRepository;
import com.abevilacqua.ch6smallsecuredwebapp.repo.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.stream.Stream;

import static com.abevilacqua.ch6smallsecuredwebapp.model.Currency.USD;
import static com.abevilacqua.ch6smallsecuredwebapp.model.EncryptionAlgorithm.BCRYPT;

@SpringBootApplication
public class Ch6SmallSecuredWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch6SmallSecuredWebAppApplication.class, args);
    }

    @Bean
    public ApplicationRunner run(UserRepository userRepository,
                                 ProductRepository productRepository,
                                 AuthorityRepository authorityRepository) {
        return initializeDb(userRepository, productRepository, authorityRepository);
    }

    private ApplicationRunner initializeDb(UserRepository userRepository,
                                           ProductRepository productRepository,
                                           AuthorityRepository authorityRepository) {
        return args -> {
            Stream.of(
                new User(
                    1,
                    "john",
                    "$2a$10$xn3LI/AjqicFYZFruSwve.681477XaVNaUQbr1gioaWPn4t1KsnmG",
                    BCRYPT,
                    new ArrayList<>()
                )
            ).forEach(userRepository::save);

            Stream.of(
                new Authority(1, "READ", userRepository.findUserByUsername("john").get()),
                new Authority(2, "WRITE", userRepository.findUserByUsername("john").get())
            ).forEach(authorityRepository::save);

            Stream.of(
                new Product(1, "Chocolate", "10", USD)
            ).forEach(productRepository::save);
        };
    }

}
