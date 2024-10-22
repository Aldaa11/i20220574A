package com.edu.cibertec.i20220574.serviceimplements;
import com.edu.cibertec.i20220574.models.Productos;
import com.edu.cibertec.i20220574.repositories.IProductosRepository;
import com.edu.cibertec.i20220574.serviceinterfaces.IProductosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductosImplements implements IProductosService {
    @Autowired
    private IProductosRepository pR;

    @Override
    public void insert(Productos productos) { pR.save(productos); }

    @Override
    public List<Productos> list() { return pR.findAll(); }

    @Override
    public void update(Productos productos) { pR.save(productos); }

    @Override
    public void delete(long idproductos) { pR.deleteById(idproductos); }

    @Override
    public Productos findById(long idproductos) { return pR.findById(idproductos).orElse(null); }
}
