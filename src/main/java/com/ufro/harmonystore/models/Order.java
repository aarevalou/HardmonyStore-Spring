package com.ufro.harmonystore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pedido")
public class Order {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "rut", nullable = false)
    private String rut;
    @Column(name = "fecha_creacion", nullable = false)
    private String fecha_creacion;
    @Column(name = "despacho_id")
    private int despacho_id;
    @Column(name = "metodo_pago", length = 20, nullable = false)
    private String metodo_pago;
    @Column(name = "detalle_id", nullable = false)
    private int detalle_id;
    @Column(name = "total", nullable = false)
    private int total;


    @OneToMany(mappedBy = "pedido")
    private List<ProductDetail> detalles;
}
