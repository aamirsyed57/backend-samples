package com.app.backend.repository;


import com.app.backend.entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

    @SuppressWarnings("NullableProblems")
    @Override
    @EntityGraph(attributePaths = {"products"})
    Iterable<Category> findAll();

    List<Category> findByName(String name);
}
