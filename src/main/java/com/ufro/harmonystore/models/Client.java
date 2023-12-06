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
@Table(name = "cliente")
public class Client extends User {

    @Column(name = "direccion", length = 50)
    private String direccion;
    @Column(name = "saldo")
    private int saldo;

    public Client(int id, String rut, String nombre, String email, String password, String direccion, String imagen, String direccion1, int saldo) {
        super(id, rut, nombre, email, password, direccion, imagen);
        this.direccion = direccion1;
        this.saldo = saldo;
    }
}
