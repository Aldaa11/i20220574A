package com.edu.cibertec.i20220574.models;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "productos")
public class Productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_producto;
    @Column(name = "nombre_producto", nullable = false, length = 50)
    private String nombre_producto;
    @Column(name = "descripcion_producto", nullable = false, length = 50)
    private String descripcion_producto;
    @Column(name = "precio", nullable = false, length = 50)
    private double precio;
    @Column(name = "stock", nullable = false, length = 50)
    private int stock;
    @Column(name = "fecha_agregado", nullable = false, length = 50)
    private LocalDate fecha_agregado;

    public Productos() {}

    public Productos(long id_producto, String nombre_producto, String descripcion_producto, double precio, int stock, LocalDate fecha_agregado) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.descripcion_producto = descripcion_producto;
        this.precio = precio;
        this.stock = stock;
        this.fecha_agregado = fecha_agregado;
    }

    public long getId_producto() {
        return id_producto;
    }

    public void setId_producto(long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDescripcion_producto() {
        return descripcion_producto;
    }

    public void setDescripcion_producto(String descripcion_producto) {
        this.descripcion_producto = descripcion_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public LocalDate getFecha_agregado() {
        return fecha_agregado;
    }

    public void setFecha_agregado(LocalDate fecha_agregado) {
        this.fecha_agregado = fecha_agregado;
    }
}