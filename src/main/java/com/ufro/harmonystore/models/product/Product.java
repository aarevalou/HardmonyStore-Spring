package com.ufro.harmonystore.models.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column(name = "marca_id", nullable = false)
    private int marca_id;

    @Column(name = "modelo", length = 50, nullable = false)
    private String modelo;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "imagen", length = 100)
    private String imagen;

    @Column(name = "categoria_id", nullable = false)
    private int categoria_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "atributo_producto",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "atributo_id")
    )
    @JsonBackReference
    private List<Atributte> atributos = new ArrayList<>();

    public void agregarAtributo(Atributte atributo) {
        this.atributos.add(atributo);
        atributo.getProductos().add(this);
    }

    public void eliminarAtributo(Atributte atributo) {
        this.atributos.remove(atributo);
        atributo.getProductos().remove(this);
    }
}
