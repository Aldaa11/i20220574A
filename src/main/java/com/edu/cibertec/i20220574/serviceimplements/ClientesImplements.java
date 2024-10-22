package com.edu.cibertec.i20220574.serviceimplements;
import com.edu.cibertec.i20220574.models.Clientes;
import com.edu.cibertec.i20220574.repositories.IClientesRepository;
import com.edu.cibertec.i20220574.serviceinterfaces.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ClientesImplements implements IClientesService {
    @Autowired
    private IClientesRepository cR;

    @Override
    public void insert(Clientes clientes) { cR.save(clientes); }

    @Override
    public List<Clientes> list() { return cR.findAll(); }

    @Override
    public void update(Clientes clientes) { cR.save(clientes); }

    @Override
    public void delete(long id_cliente) { cR.deleteById(id_cliente); }

    @Override
    public Clientes findById(long id_cliente) { return cR.findById(id_cliente).orElse(null); }
}
