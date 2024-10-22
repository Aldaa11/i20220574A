package com.edu.cibertec.i20220574.models;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "clientes")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cliente;
    @Column(name = "nombre_cliente", nullable = false, length = 50)
    private String nombre_cliente;
    @Column(name = "email_cliente", nullable = false, length = 50)
    private String email_cliente;
    @Column(name = "telefono_cliente", nullable = false)
    private int telefono_cliente;
    @Column(name = "direccion_cliente", nullable = false, length = 150)
    private String direccion_cliente;
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fecha_registro;

    public Clientes() {}

    public Clientes(long id_cliente, String nombre_cliente, String email_cliente, int telefono_cliente, String direccion_cliente, LocalDate fecha_registro) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.email_cliente = email_cliente;
        this.telefono_cliente = telefono_cliente;
        this.direccion_cliente = direccion_cliente;
        this.fecha_registro = fecha_registro;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public int getTelefono_cliente() {
        return telefono_cliente;
    }

    public void setTelefono_cliente(int telefono_cliente) {
        this.telefono_cliente = telefono_cliente;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
}
