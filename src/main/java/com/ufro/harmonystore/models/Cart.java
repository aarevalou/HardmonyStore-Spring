package com.ufro.harmonystore.models;

import com.ufro.harmonystore.models.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "carrito")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "cliente_id", unique = true, nullable = false)
    private Client cliente;
    @ManyToOne
    @JoinColumn(name = "producto_id", unique = true, nullable = false)
    private Product producto;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;

}
