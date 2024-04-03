package com.example.Microservices.config;

import com.example.Microservices.model.Product;
import com.example.Microservices.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product bread = new Product(
                    "bread",
                    "Whole bread loaf",
                    12.50,
                    12
            );
            Product milk = new Product(
                    "milk",
                    "full cream milk",
                    20,
                    15
            );
            Product Tea = new Product(
                    "Tea",
                    "full cream milk",
                    20,
                    15
            );
            Product Coffee = new Product(
                    "Coffee",
                    "full cream milk",
                    20,
                    15
            );
            Product Bags = new Product(
                    "Bags",
                    "full cream milk",
                    20,
                    15
            );
            Product Socks = new Product(
                    "Socks",
                    "",
                    20,
                    15
            );
            Product mouthwash = new Product(
                    "mouthwash",
                    "",
                    20,
                    15
            );
            Product HairGel = new Product(
                    "HairGel",
                    "",
                    20,
                    15
            );
            Product Shampoo = new Product(
                    "Shampoo",
                    "",
                    20,
                    15
            );


            productRepository.saveAll(
                    List.of(Tea,Coffee,bread,milk,Bags,HairGel,Shampoo,mouthwash,Socks)
            );
        };
    }
}
