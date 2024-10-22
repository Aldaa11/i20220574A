package com.edu.cibertec.i20220574.serviceinterfaces;
import com.edu.cibertec.i20220574.models.Empleados;
import java.util.List;
public interface IEmpleadosService {
    public void insert(Empleados empleados);
    public List<Empleados> list();
    public void update(Empleados empleados);
    public void delete(long idempleado);
    public Empleados findById(long id);
}