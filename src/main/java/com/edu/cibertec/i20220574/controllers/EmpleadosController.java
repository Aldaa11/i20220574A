package com.edu.cibertec.i20220574.controllers;
import com.edu.cibertec.i20220574.models.Empleados;
import com.edu.cibertec.i20220574.serviceinterfaces.IEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/empleados")
public class EmpleadosController {
    @Autowired
    private IEmpleadosService eS;
    @GetMapping
    public List<Empleados> mostrar() {
        return eS.list();
    }
    @PostMapping
    public void agregar(@RequestBody Empleados empleados) {
        eS.insert(empleados);
    }
    @PutMapping
    public void actualizar(@RequestBody Empleados empleados) {
        eS.update(empleados);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") long id) {
        eS.delete(id);
    }

    // part sir

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Empleados> empleados = eS.list();
        model.addAttribute("listaEmpleados", empleados);
        return "/empleados/inicio";
    }
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("crearEmpleados", new Empleados());
        return "/empleados/crear";
    }
    @PostMapping("/crear")
    public String crear(Empleados empleados) {
        System.out.println("Empleado código: " + empleados.getId_empleado());
        eS.insert(empleados);
        return "redirect:/empleados/inicio";
    }
    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable long codigo, Model model) {
        Empleados objEmp = eS.findById(codigo);
        if (objEmp != null) {
            model.addAttribute("objEmp", objEmp);
        }
        return "/empleados/editar";
    }
    @PostMapping("/editar/{codigo}")
    public String actualizarEmpleado(@PathVariable long codigo, Empleados empleados) {
        Empleados empleadoExistente = eS.findById(codigo);
        if (empleadoExistente != null) {
            empleadoExistente.setNombre_empleado(empleados.getNombre_empleado());
            empleadoExistente.setEmail_empleado(empleados.getEmail_empleado());
            empleadoExistente.setTelefono_empleado(empleados.getTelefono_empleado());
            empleadoExistente.setPuesto(empleados.getPuesto());
            empleadoExistente.setFecha_contratacion(empleados.getFecha_contratacion());
            eS.update(empleadoExistente);
        }
        return "redirect:/empleados/inicio";
    }
    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo, Model model) {
        Empleados objEmp = eS.findById(codigo);
        model.addAttribute("objCobjEmpli", objEmp);
        return "/empleados/eliminar";
    }
    @PostMapping("/eliminar")
    public String eliminar(Empleados empleados) {
        eS.delete(empleados.getId_empleado());
        return "redirect:/empleados/inicio";
    }
}