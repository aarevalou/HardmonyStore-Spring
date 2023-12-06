package com.ufro.harmonystore.services;
import com.ufro.harmonystore.models.product.Product;
import com.ufro.harmonystore.repository.productos.CartRepository;
import com.ufro.harmonystore.repository.productos.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    final private CartRepository cartRepository;
    final private ProductRepository productRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public List<Product> getProductosEnCarrito() {
        List<Product> productosEnCarrito = new ArrayList<>();
        return productosEnCarrito;
    }

    public void agregarProductoAlCarrito(int id) {
        Product producto = productRepository.findById(id);
    }

    public void removerProductoDelCarrito(int id) {
        cartRepository.deleteById(id);
    }

    public void vaciarCarrito() {
        cartRepository.deleteAll();
    }
}
