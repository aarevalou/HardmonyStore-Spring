package com.ufro.harmonystore.services;

import com.ufro.harmonystore.models.Order;
import com.ufro.harmonystore.repository.pedidos.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    //CRUD
    public List<Order> findOrders(){
        return orderRepository.findAll();
    }

    public void savePedido(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public Order findOrderById(int id) {
        return orderRepository.findById(id);
    }
    public List<Order> findOrdersByRut(String rut) {
        return orderRepository.findByRut(rut);
    }

    public void deleteOrders(){
        orderRepository.deleteAll();
    }
    public Order updateOrderById(int id, Order newOrder){
        Order order = orderRepository.findById(id);

        if(order != null){
             order.setDetalles(newOrder.getDetalles());
             order.setTotal(newOrder.getTotal());
             order.setDespacho_id(newOrder.getDespacho_id());
             order.setRut(newOrder.getRut());
             order.setMetodo_pago(newOrder.getMetodo_pago());
             order.setFecha_creacion(newOrder.getFecha_creacion());

             return orderRepository.save(order);
        }
        else{
            return null;
        }
    }

}
