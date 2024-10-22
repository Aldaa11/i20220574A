package com.edu.cibertec.i20220574.serviceimplements;
import com.edu.cibertec.i20220574.models.DetalleVenta;
import com.edu.cibertec.i20220574.repositories.IDetalleVentaRepository;
import com.edu.cibertec.i20220574.serviceinterfaces.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DetalleVentaImplements implements IDetalleVentaService {
    @Autowired
    private IDetalleVentaRepository vR;

    @Override
    public void insert(DetalleVenta detalleVenta) { vR.save(detalleVenta); }

    @Override
    public List<DetalleVenta> list() { return vR.findAll(); }

    @Override
    public void update(DetalleVenta detalleVenta) { vR.save(detalleVenta); }

    @Override
    public void delete(long id_detalleVenta) { vR.deleteById(id_detalleVenta); }

    @Override
    public DetalleVenta findById(long id_detalleVenta) { return vR.findById(id_detalleVenta).orElse(null); }
}
