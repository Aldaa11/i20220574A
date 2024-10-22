package com.edu.cibertec.i20220574.models;
import jakarta.persistence.*;
@Entity
@Table(name = "detalleventa")
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_detalle;
    @ManyToOne
    @JoinColumn(name = "id_venta")
    private Ventas id_venta;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Productos id_producto;
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Column(name = "precio_unitario", nullable = false)
    private double precio_unitario;
    public DetalleVenta() {}

    public DetalleVenta(long id_detalle, Ventas id_venta, Productos id_producto, int cantidad, double precio_unitario) {
        this.id_detalle = id_detalle;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
    }

    public long getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(long id_detalle) {
        this.id_detalle = id_detalle;
    }

    public Ventas getId_venta() {
        return id_venta;
    }

    public void setId_venta(Ventas id_venta) {
        this.id_venta = id_venta;
    }

    public Productos getId_producto() {
        return id_producto;
    }

    public void setId_producto(Productos id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }
}
