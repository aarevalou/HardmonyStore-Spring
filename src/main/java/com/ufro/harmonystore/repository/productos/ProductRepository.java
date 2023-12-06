package com.ufro.harmonystore.repository.productos;

import com.ufro.harmonystore.models.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    List<Product> findAll();
    Product findById(int id);
    void deleteById(int id);

}
