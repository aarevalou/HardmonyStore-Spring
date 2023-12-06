package com.ufro.harmonystore.controller;

import com.ufro.harmonystore.models.Order;
import com.ufro.harmonystore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public List<Order> getAllOrders() {
        return orderService.findOrders();
    }

    @GetMapping("/rut")
    public List<Order> getOrdersByRut(@RequestParam("rut") String rut) {
        return orderService.findOrdersByRut(rut);
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        return orderService.findOrderById(id);
    }

    @PostMapping("/save")
    public void saveOrder(@RequestBody Order order) {
        orderService.savePedido(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        orderService.updateOrderById(id, order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }

    @DeleteMapping("")
    public void deleteAllOrders() {
        orderService.deleteOrders();
    }
}
