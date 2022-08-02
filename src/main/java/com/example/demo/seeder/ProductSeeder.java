package com.example.demo.seeder;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.util.NumberHelper;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductSeeder {
    private static final int NUMBER_OF_PRODUCTS = 100;
    public static List<Product> productList = new ArrayList<>();
    final ProductRepository productRepository;

    public void generate() {
        Faker faker = new Faker();
        for (int i = 0; i < NUMBER_OF_PRODUCTS; i++
        ) {
            Product product = Product.builder()
                    .name(faker.name().title())
                    .dateOfManf(LocalDateTime.now().minus(NumberHelper.generateRandom(1, 30)))
                    .description(faker.weather().description())
                    .price(NumberHelper.generateRandom(100000, 1000000))
                    .build();
            productList.add(product);
        }
        productRepository.saveAll(productList);
    }
}
