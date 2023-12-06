package com.ufro.harmonystore.repository.pedidos;

import com.ufro.harmonystore.models.ProductDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepository extends CrudRepository<ProductDetail, Integer> {
    List<ProductDetail> findAll();
    ProductDetail findById(int id);
    void deleteById(int id);
}
