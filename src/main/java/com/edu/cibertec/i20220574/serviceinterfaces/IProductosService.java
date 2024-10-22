package com.edu.cibertec.i20220574.serviceinterfaces;
import com.edu.cibertec.i20220574.models.Productos;
import java.util.List;
public interface IProductosService {
    public void insert(Productos productos);
    public List<Productos> list();
    public void update(Productos productos);
    public void delete(long idproductos);
    public Productos findById(long idproductos);
}
