package com.ufro.harmonystore.models.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "atributo")
public class Atributte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @ManyToMany(mappedBy = "atributos")
    private Set<Product> productos;

    public Atributte() {
        this.productos = new HashSet<>();
    }
    public void agregarProducto(Product producto) {
        this.productos.add(producto);
        producto.getAtributos().add(this);
    }
    public void eliminarProducto(Product producto) {
        this.productos.remove(producto);
        producto.getAtributos().remove(this);
    }
}
