package com.ufro.harmonystore.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "despacho")
public class Dispatch {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "metodo_despacho", length = 15, nullable = false)
    private String metodo_despacho;
    @Column(name = "costo_despacho", nullable = false)
    private int costo_despacho;
    @Column(name = "comuna", nullable = false)
    private String comuna;
    @Column(name = "direccion", length = 25, nullable = false)
    private String direccion;
    @Column(name = "region", length = 25, nullable = false)
    private String region;
}
