package com.ufro.harmonystore.repository.productos;

import com.ufro.harmonystore.models.product.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAll();
    Category findById(int id);
    void deleteById(int id);
}
