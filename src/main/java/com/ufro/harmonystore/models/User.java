package com.ufro.harmonystore.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "rut", length = 11,nullable = false, unique = true)
    private String rut;
    @Column(name = "nombre", length = 50, nullable = false, unique = true)
    private String nombre;
    @Column(name = "email", length = 50,nullable = false, unique = true)
    private String email;
    @Column(name = "password", length = 10,nullable = false, unique = true)
    private String password;
    @Column(name = "direccion", length = 25,nullable = false, unique = true)
    private String direccion;
    @Column(name = "imagen", length = 100, unique = true)
    private String imagen;
}
