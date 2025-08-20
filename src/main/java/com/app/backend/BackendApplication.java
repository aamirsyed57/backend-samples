package com.app.backend;

import com.app.backend.entity.Category;
import com.app.backend.entity.Product;
import com.app.backend.repository.CategoryRepository;
import com.app.backend.repository.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            Category tables = new Category("Tables");
            Category sofas = new Category( "Sofas");

            categoryRepository.saveAll(List.of(tables,sofas));
            Product table = new Product( "Red Table", new BigDecimal("10.0") , 100, tables);
            Product sofa = new Product("Blue Sofa",new BigDecimal("10.0") , 100, sofas);
            productRepository.saveAll(List.of(table, sofa));

        };
    }

}
