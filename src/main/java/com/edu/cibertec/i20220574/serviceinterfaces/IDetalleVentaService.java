package com.edu.cibertec.i20220574.serviceinterfaces;
import com.edu.cibertec.i20220574.models.DetalleVenta;
import java.util.List;
public interface IDetalleVentaService {
    public void insert(DetalleVenta detalleVenta);
    public List<DetalleVenta> list();
    public void update(DetalleVenta detalleVenta);
    public void delete(long id_detalleVenta);
    public DetalleVenta findById(long id_detalleVenta);
}