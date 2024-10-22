package com.edu.cibertec.i20220574.models;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_venta;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Clientes id_cliente;
    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleados id_empleado;
    @Column(name = "fecha_venta", nullable = false)
    private LocalDate fecha_venta;
    @Column(name = "total", nullable = false)
    private int total;
    public Ventas() {}

    public Ventas(long id_venta, Clientes id_cliente, Empleados id_empleado, LocalDate fecha_venta, int total) {
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.fecha_venta = fecha_venta;
        this.total = total;
    }

    public long getId_venta() {
        return id_venta;
    }

    public void setId_venta(long id_venta) {
        this.id_venta = id_venta;
    }

    public Clientes getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Clientes id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Empleados getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Empleados id_empleado) {
        this.id_empleado = id_empleado;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
