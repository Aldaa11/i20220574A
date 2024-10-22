package com.edu.cibertec.i20220574.serviceimplements;
import com.edu.cibertec.i20220574.models.Empleados;
import com.edu.cibertec.i20220574.repositories.IEmpleadosRepository;
import com.edu.cibertec.i20220574.serviceinterfaces.IEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmpleadosImplements implements IEmpleadosService {
    @Autowired
    private IEmpleadosRepository eR;

    @Override
    public void insert(Empleados empleados) { eR.save(empleados); }

    @Override
    public List<Empleados> list() { return eR.findAll(); }

    @Override
    public void update(Empleados empleados) { eR.save(empleados); }

    @Override
    public void delete(long idempleado) { eR.deleteById(idempleado); }

    @Override
    public Empleados findById(long id) { return eR.findById(id).orElse(null); }
}