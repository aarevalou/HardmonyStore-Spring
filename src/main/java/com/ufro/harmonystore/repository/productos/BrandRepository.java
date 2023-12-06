package com.ufro.harmonystore.repository.productos;

import com.ufro.harmonystore.models.product.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Integer> {
    List<Brand> findAll();
    Brand findById(int id);
    void deleteById(int id);
}
