package com.edu.cibertec.i20220574.controllers;
import com.edu.cibertec.i20220574.models.Clientes;
import com.edu.cibertec.i20220574.serviceinterfaces.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*@RestController*/
@Controller
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private IClientesService cS;
    @GetMapping
    public List<Clientes> mostrar() {
        return cS.list();
    }
    @PostMapping
    public void agregar(@RequestBody Clientes clientes) {
        cS.insert(clientes);
    }
    @PutMapping
    public void modificar(@RequestBody Clientes clientes) {
        cS.update(clientes);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") long id) {
        cS.delete(id);
    }

    // part sir

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Clientes> clientes = cS.list();
        model.addAttribute("listaClientes", clientes);
        return "/clientes/inicio";
    }
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("crearClientes", new Clientes());
        return "/clientes/crear";
    }
    @PostMapping("/crear")
    public String crear(Clientes clientes) {
        System.out.println("Cliente código: " + clientes.getId_cliente());
        cS.insert(clientes);
        return "redirect:/clientes/inicio";
    }
    @GetMapping("/editar/{codigo}")
    public String mostrarFormularioEditar(@PathVariable long codigo, Model model) {
        Clientes clienteExistente = cS.findById(codigo);
        if (clienteExistente != null) {
            model.addAttribute("objCli", clienteExistente);
        }
        return "/clientes/editar";
    }

    @PostMapping("/editar/{codigo}")
    public String actualizarCliente(@PathVariable long codigo, Clientes clientes) {
        Clientes clienteExistente = cS.findById(codigo);
        if (clienteExistente != null) {
            clienteExistente.setNombre_cliente(clientes.getNombre_cliente());
            clienteExistente.setEmail_cliente(clientes.getEmail_cliente());
            clienteExistente.setTelefono_cliente(clientes.getTelefono_cliente());
            clienteExistente.setDireccion_cliente(clientes.getDireccion_cliente());
            clienteExistente.setFecha_registro(clientes.getFecha_registro());
            cS.update(clienteExistente);
        }
        return "redirect:/clientes/inicio";
    }
    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo, Model model) {
        Clientes objCli = cS.findById(codigo);
        model.addAttribute("objCli", objCli);
        return "/clientes/eliminar";
    }
    @PostMapping("/eliminar")
    public String eliminar(Clientes clientes) {
        cS.delete(clientes.getId_cliente());
        return "redirect:/clientes/inicio";
    }
}