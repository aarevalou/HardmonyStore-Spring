package com.ufro.harmonystore.repository.pedidos;
import com.ufro.harmonystore.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAll();
    Order findById(int id);
    List<Order> findByRut(String rut);

    void deleteById(int id);
}
