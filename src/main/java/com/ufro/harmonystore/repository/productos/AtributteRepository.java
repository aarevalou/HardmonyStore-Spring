package com.ufro.harmonystore.repository.productos;

import com.ufro.harmonystore.models.product.Atributte;
import com.ufro.harmonystore.models.product.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtributteRepository extends CrudRepository<Atributte, Integer> {
    List<Atributte> findAll();
    Atributte findById(int id);
    List<Atributte> findByProductos(Product producto);
    void deleteById(int id);
}
