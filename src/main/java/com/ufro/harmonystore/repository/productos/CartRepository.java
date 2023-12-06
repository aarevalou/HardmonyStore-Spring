package com.ufro.harmonystore.repository.productos;

import com.ufro.harmonystore.models.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
    List<Cart> findAll();
    Cart findById(int id);
    void deleteById(int id);
}
