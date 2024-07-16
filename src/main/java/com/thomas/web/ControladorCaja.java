/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.web;

import com.thomas.domain.Caja;
import com.thomas.servicio.CajaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author sergio
 */
@Controller
@Slf4j
public class ControladorCaja {

    @Autowired
    private CajaService cajaService;
    
    @GetMapping("/cajas")
    public String listarCajas(Model model) {
        var cajas = cajaService.listarCajas();
        model.addAttribute("cajas", cajas);
        return "cajas";
    }
    
    @GetMapping("/agregarCaja")
    public String agregarCaja(Caja caja) {
        return "modificarCaja";
    }
    
    @PostMapping("/guardarCaja")
    public String guardarCaja(Caja caja) {
        cajaService.guardarCaja(caja);
        return "redirect:/cajas";
    }
    
    @GetMapping("/editarCaja/{idCaja}")
    public String editarCaja(@PathVariable("idCaja") Long idCaja, Model model) {
         Caja caja = cajaService.encontrarCaja(idCaja);
        if (caja == null) {
            // Manejo de caso en el que no se encuentra la caja
            log.error("Caja no encontrada para el id: " + idCaja);
            return "error";
        }
        model.addAttribute("caja", caja);
        return "modificarCaja";
    }
    
    @GetMapping("/eliminarCaja/{idCaja}")
    public String eliminarCaja(Caja caja) {
        cajaService.eliminarCaja(caja);
        return "redirect:/cajas";
    }
}
