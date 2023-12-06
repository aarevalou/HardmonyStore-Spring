package com.ufro.harmonystore.models;
import com.ufro.harmonystore.models.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "detalle_pedido")
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private int cantidad;
    private int precio;
    private int total;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Order pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Product producto;

    public ProductDetail(Integer id, String nombre, int cantidad, int precio, int total) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    @Override
    public String toString() {
        return "DetalleOrden [id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio
                + ", total=" + total + "]";
    }

}
