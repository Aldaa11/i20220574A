package com.edu.cibertec.i20220574.controllers;
import com.edu.cibertec.i20220574.models.DetalleVenta;
import com.edu.cibertec.i20220574.serviceinterfaces.IDetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/detalleventa")
public class DetalleVentaController {
    @Autowired
    private IDetalleVentaService dV;
    @GetMapping
    public List<DetalleVenta> mostrar() {
        return dV.list();
    }
    @PostMapping
    public void agregar(@RequestBody DetalleVenta detalleventa) {
        dV.insert(detalleventa);
    }
    @PutMapping
    public void actualizar(@RequestBody DetalleVenta detalleventa) {
        dV.update(detalleventa);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") long id) {
        dV.delete(id);
    }

    // part sir

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<DetalleVenta> clientes = dV.list();
        model.addAttribute("listaDetalleVenta", clientes);
        return "/detalleventa/inicio";
    }
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("crearDetalleVenta", new DetalleVenta());
        return "/detalleventa/crear";
    }
    @PostMapping("/crear")
    public String crear(DetalleVenta detalleVenta) {
        System.out.println("Detalle Venta código: " + detalleVenta.getId_detalle());
        dV.insert(detalleVenta);
        return "redirect:/detalleventa/inicio";
    }
    @GetMapping("/editar/{codigo}")
    public String mostrarFormularioEditar(@PathVariable long codigo, Model model) {
        DetalleVenta objDeta = dV.findById(codigo);
        if (objDeta != null) {
            model.addAttribute("objDetal", objDeta);
        }
        return "/detalleventa/editar";
    }
    @PostMapping("/editar/{codigo}")
    public String actualizarCliente(@PathVariable long codigo, DetalleVenta detalleVenta) {
        DetalleVenta detalleVentaExiste = dV.findById(codigo);
        if (detalleVentaExiste != null) {
            detalleVentaExiste.setId_venta(detalleVenta.getId_venta());
            detalleVentaExiste.setId_producto(detalleVenta.getId_producto());
            detalleVentaExiste.setCantidad(detalleVenta.getCantidad());
            detalleVentaExiste.setPrecio_unitario(detalleVenta.getPrecio_unitario());
            dV.update(detalleVentaExiste);
        }
        return "redirect:/detalleventa/inicio";
    }
    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo, Model model) {
        DetalleVenta objDetal = dV.findById(codigo);
        model.addAttribute("objDetal", objDetal);
        return "/detalleventa/eliminar";
    }
    @PostMapping("/eliminar")
    public String eliminar(DetalleVenta detalleVenta) {
        dV.delete(detalleVenta.getId_detalle());
        return "redirect:/detalleventa/inicio";
    }
}