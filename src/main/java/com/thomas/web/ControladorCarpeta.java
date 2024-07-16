package com.thomas.web;

import com.thomas.domain.Bolsa;
import com.thomas.domain.Carpeta;
import com.thomas.servicio.BolsaService;
import com.thomas.servicio.CarpetaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorCarpeta {

    @Autowired
    private CarpetaService carpetaService;
    
    @Autowired
    private BolsaService bolsaService;

    @GetMapping("/carpetas")
    public String listarCarpetas(Model model) {
        var carpetas = carpetaService.listarCarpetas();
        model.addAttribute("carpetas", carpetas);
        return "carpetas"; 
    }

    @GetMapping("/agregarCarpeta")
    public String agregarCarpeta(Carpeta carpeta, Model model) {
        model.addAttribute("bolsas", bolsaService.listarBolsas());
        return "modificarCarpeta"; 
    }

    @PostMapping("/guardarCarpeta")
    public String guardarCarpeta(Carpeta carpeta) {
        carpetaService.guardarCarpeta(carpeta);
        return "redirect:/carpetas";
    }

    @GetMapping("/editarCarpeta/{idCarpeta}")
    public String editarCarpeta(@PathVariable("idCarpeta") Long idCarpeta, Model model) {
        Carpeta carpeta = carpetaService.encontrarCarpeta(idCarpeta);
        if (carpeta == null) {
            log.error("Carpeta no encontrada para el id: " + idCarpeta);
            return "error";
        }
        model.addAttribute("carpeta", carpeta);
        model.addAttribute("bolsas", bolsaService.listarBolsas());
        return "modificarCarpeta"; 
    }

    @GetMapping("/eliminarCarpeta/{idCarpeta}")
    public String eliminarCarpeta(@PathVariable("idCarpeta") Long idCarpeta) {
        Carpeta carpeta = carpetaService.encontrarCarpeta(idCarpeta);
        carpetaService.eliminarCarpeta(carpeta);
        return "redirect:/carpetas";
    }
}
