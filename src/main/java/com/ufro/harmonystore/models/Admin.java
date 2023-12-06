package com.ufro.harmonystore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "admin")
public class Admin extends User {

    @Column(name = "fecha_ingreso", nullable = false)
    private String fecha_ingreso;
    @Column(name = "cargo", length = 20, nullable = false)
    private String cargo;

    public Admin(int id, String rut, String nombre, String email, String password, String direccion, String imagen, String fecha_ingreso, String cargo) {
        super(id, rut, nombre, email, password, direccion, imagen);
        this.fecha_ingreso = fecha_ingreso;
        this.cargo = cargo;
    }
}
