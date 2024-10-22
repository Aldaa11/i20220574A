package com.edu.cibertec.i20220574.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class InicioController {
    @GetMapping
    public String indice() {
        return "index";
    }
}
