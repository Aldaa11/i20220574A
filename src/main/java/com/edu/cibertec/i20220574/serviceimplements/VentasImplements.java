package com.edu.cibertec.i20220574.serviceimplements;
import com.edu.cibertec.i20220574.models.Ventas;
import com.edu.cibertec.i20220574.repositories.IVentasRepository;
import com.edu.cibertec.i20220574.serviceinterfaces.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class VentasImplements implements IVentasService {
    @Autowired
    private IVentasRepository vR;
    @Override
    public void insert(Ventas ventas) { vR.save(ventas); }

    @Override
    public List<Ventas> list() { return vR.findAll(); }

    @Override
    public void update(Ventas ventas) { vR.save(ventas); }

    @Override
    public void delete(long idventas) { vR.deleteById(idventas); }

    @Override
    public Ventas findById(long idventas) { return vR.findById(idventas).orElse(null); }
}