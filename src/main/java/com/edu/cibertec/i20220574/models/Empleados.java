package com.edu.cibertec.i20220574.models;
import jakarta.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "empleados")
public class Empleados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_empleado;
    @Column(name = "nombre_empleado", nullable = false, length = 50)
    private String nombre_empleado;
    @Column(name = "email_empleado", nullable = false, length = 80)
    private String email_empleado;
    @Column(name = "telefono_empleado", nullable = false)
    private int telefono_empleado;
    @Column(name = "puesto", nullable = false, length = 50)
    private String puesto;
    @Column(name = "fecha_contratacion", nullable = false)
    private LocalDate fecha_contratacion;

    public Empleados() {}

    public Empleados(long id_empleado, String nombre_empleado, String email_empleado, int telefono_empleado, String puesto, LocalDate fecha_contratacion) {
        this.id_empleado = id_empleado;
        this.nombre_empleado = nombre_empleado;
        this.email_empleado = email_empleado;
        this.telefono_empleado = telefono_empleado;
        this.puesto = puesto;
        this.fecha_contratacion = fecha_contratacion;
    }

    public long getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(long id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getEmail_empleado() {
        return email_empleado;
    }

    public void setEmail_empleado(String email_empleado) {
        this.email_empleado = email_empleado;
    }

    public int getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(int telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public LocalDate getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(LocalDate fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }
}