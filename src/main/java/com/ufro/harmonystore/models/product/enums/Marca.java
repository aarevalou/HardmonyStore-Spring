package com.ufro.harmonystore.models.product.enums;

public enum Marca {
    Intel("Intel"), AMD("AMD"), Nvidia("Nvidia"),
    Crucial("Crucial"), Kingston("Kingston"), Gigabyte("Gigabyte"),
    ASUS("ASUS"), Western_Digital("Western Digital");

    private final String Marca;

    Marca(String Marca){
        this.Marca = Marca;
    }
    public String getMarca(){
        return Marca;
    }
}
