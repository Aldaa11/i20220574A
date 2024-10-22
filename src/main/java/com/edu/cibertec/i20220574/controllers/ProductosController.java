package com.edu.cibertec.i20220574.controllers;
import com.edu.cibertec.i20220574.models.Clientes;
import com.edu.cibertec.i20220574.models.Productos;
import com.edu.cibertec.i20220574.serviceinterfaces.IProductosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/productos")
public class ProductosController {
    private IProductosService pS;
    @GetMapping
    public List<Productos> mostrar() {
        return pS.list();
    }
    @PostMapping
    public void agregar(@RequestBody Productos productos) {
        pS.insert(productos);
    }
    @PutMapping
    public void modificar(@RequestBody Productos productos) {
        pS.update(productos);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") long id) {
        pS.delete(id);
    }

    // part sir

    @GetMapping("/inicio")
    public String inicio(Model model) {
        List<Productos> productos = pS.list();
        model.addAttribute("listaProductos", productos);
        return "/productos/inicio";
    }
    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("crearProductos", new Productos());
        return "/productos/crear";
    }
    @PostMapping("/crear")
    public String crear(Productos productos) {
        System.out.println("Producto código: " + productos.getId_producto());
        pS.insert(productos);
        return "redirect:/productos/inicio";
    }
    @GetMapping("/editar/{codigo}")
    public String editar(@PathVariable long codigo, Model model) {
        Productos objPro = pS.findById(codigo);
        if (objPro != null) {
            model.addAttribute("objPro", objPro);
        }
        return "/productos/editar";
    }
    @PostMapping("/editar/{codigo}")
    public String actualizarProducto(@PathVariable long codigo, Productos productos) {
        Productos productosExistente = pS.findById(codigo);
        if (productosExistente != null) {
            productosExistente.setNombre_producto(productos.getNombre_producto());
            productosExistente.setDescripcion_producto(productos.getDescripcion_producto());
            productosExistente.setPrecio(productos.getPrecio());
            productosExistente.setStock(productos.getStock());
            productosExistente.setFecha_agregado(productos.getFecha_agregado());
            pS.update(productosExistente);
        }
        return "redirect:/productos/inicio";
    }
    @GetMapping("/eliminar/{codigo}")
    public String eliminar(@PathVariable Long codigo, Model model) {
        Productos objPro = pS.findById(codigo);
        model.addAttribute("objPro", objPro);
        return "/productos/eliminar";
    }
    @PostMapping("/eliminar")
    public String eliminar(Productos productos) {
        pS.delete(productos.getId_producto());
        return "redirect:/productos/inicio";
    }
}