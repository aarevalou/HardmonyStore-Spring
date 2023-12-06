package com.ufro.harmonystore.models.product.enums;

public enum Categoria {
    PROCESADOR("Procesadores"), TARJETA_GRAFICA("Tarjetas Gráficas"), PLACA_MADRE("Placas Madre"),
        MEMORIAS_RAM("Memorias RAM"), ALMACENAMIENTO("Almacenamiento"), FUENTE_PODER("Fuentes de poder");

    private final String categoria;

    Categoria(String categoria){
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }
}
