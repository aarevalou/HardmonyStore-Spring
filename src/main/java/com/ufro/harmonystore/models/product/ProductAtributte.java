package com.ufro.harmonystore.models.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "atributo_producto")
public class ProductAtributte {
    @Id
    private int id;
    @Column(name = "valor", nullable = false, length = 20)
    private String valor;

}
