package com.edu.cibertec.i20220574.serviceinterfaces;
import com.edu.cibertec.i20220574.models.Ventas;
import java.util.List;
public interface IVentasService {
    public void insert(Ventas ventas);
    public List<Ventas> list();
    public void update(Ventas ventas);
    public void delete(long idventas);
    public Ventas findById(long idventas);
}