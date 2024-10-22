package com.edu.cibertec.i20220574.controllers;
import com.edu.cibertec.i20220574.models.Ventas;
import com.edu.cibertec.i20220574.serviceinterfaces.IVentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/ventas")
public class VentasController {
    @Autowired
    private IVentasService vS;
    @GetMapping
    public List<Ventas> mostrar() {
        return vS.list();
    }
    @PostMapping
    public void agregar(@RequestBody Ventas ventas) {
        vS.insert(ventas);
    }
    @PutMapping
    public void modificar(@RequestBody Ventas ventas) {
        vS.insert(ventas);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") long id) {
        vS.delete(id);
    }

    // part sir

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Ventas> ventas = vS.list();
        model.addAttribute("listaVentas", ventas);
        return "/ventas/inicio";
    }
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("crearVentas", new Ventas());
        return "/ventas/crear";
    }
    @PostMapping("/crear")
    public String crear(Ventas ventas) {
        System.out.println("Venta código: " + ventas.getId_venta());
        vS.insert(ventas);
        return "redirect:/ventas/inicio";
    }
    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable long codigo, Model model) {
        Ventas objVen = vS.findById(codigo);
        model.addAttribute("objVen", objVen);
        return "/ventas/editar";
    }
    @PostMapping("/editar/{codigo}")
    public String actualizarVenta(@PathVariable long codigo, Ventas ventas) {
        Ventas ventaExistente = vS.findById(codigo);
        if (ventaExistente != null) {
            ventaExistente.setId_cliente(ventas.getId_cliente());
            ventaExistente.setId_empleado(ventas.getId_empleado());
            ventaExistente.setFecha_venta(ventas.getFecha_venta());
            ventaExistente.setTotal(ventas.getTotal());
            vS.update(ventaExistente);
        }
        return "redirect:/ventas/inicio";
    }
    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo, Model model) {
        Ventas objVen = vS.findById(codigo);
        model.addAttribute("objCli", objVen);
        return "/ventas/eliminar";
    }
    @PostMapping("/eliminar")
    public String eliminar(Ventas ventas) {
        vS.delete(ventas.getId_venta());
        return "redirect:/ventas/inicio";
    }
}