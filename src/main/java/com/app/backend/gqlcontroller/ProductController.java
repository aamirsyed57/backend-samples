package com.app.backend.gqlcontroller;

import com.app.backend.entity.Category;
import com.app.backend.entity.Product;
import com.app.backend.exception.CategoryNameAlreadyExist;
import com.app.backend.exception.CategoryDoesNotExist;
import com.app.backend.repository.CategoryRepository;
import com.app.backend.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ProductController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    record ProductInput(String name, BigDecimal price, int stock, Long categoryId) {
    }

    record CategoryInput(String name) {
    }

    @QueryMapping
    Iterable<Category> categories() {
        return categoryRepository.findAll();
    }

    @QueryMapping
    Optional<Category> categoryById(@Argument Long id) {
        return categoryRepository.findById(id);
    }

    @MutationMapping
    Product addProduct(@Argument ProductInput product) {
        Category category = categoryRepository.findById(product.categoryId).orElseThrow(() -> new CategoryDoesNotExist( product.categoryId));
        Product newProduct = new Product(product.name, product.price, product.stock, category);
        return productRepository.save(newProduct);
    }

    @MutationMapping
    Category addCategory(@Argument CategoryInput category) {
        List<Category> existingCategoryList = categoryRepository.findByName(category.name);
        if (!existingCategoryList.isEmpty()) {
            throw new CategoryNameAlreadyExist(String.format(category.name));
        }
        return categoryRepository.save(new Category(category.name));
    }
}
