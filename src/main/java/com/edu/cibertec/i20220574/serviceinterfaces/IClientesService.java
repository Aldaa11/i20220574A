package com.edu.cibertec.i20220574.serviceinterfaces;
import com.edu.cibertec.i20220574.models.Clientes;
import java.util.List;
public interface IClientesService {
    public void insert(Clientes clientes);
    public List<Clientes> list();
    public void update(Clientes clientes);
    public void delete(long id_cliente);
    public Clientes findById(long id_cliente);
}
