package com.thomas.web;

import com.thomas.domain.Bolsa;
import com.thomas.servicio.BolsaService;
import com.thomas.servicio.CajaService; 
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorBolsa {

    @Autowired
    private BolsaService bolsaService;
    
    @Autowired
    private CajaService cajaService; 
    
    @GetMapping("/bolsas")
    public String listarBolsas(Model model) {
        var bolsas = bolsaService.listarBolsas();
        model.addAttribute("bolsas", bolsas);
        return "bolsas";
    }
    
    @GetMapping("/agregarBolsa")
    public String agregarBolsa(Bolsa bolsa, Model model) {
        model.addAttribute("cajas", cajaService.listarCajas());
        return "modificarBolsa";
    }
    
    @PostMapping("/guardarBolsa")
    public String guardarBolsa(Bolsa bolsa) {
        bolsaService.guardarBolsa(bolsa);
        return "redirect:/bolsas";
    }
    
    @GetMapping("/editarBolsa/{idBolsa}")
    public String editarBolsa(@PathVariable("idBolsa") Long idBolsa, Model model) {
        Bolsa bolsa = bolsaService.encontrarBolsa(idBolsa);
        if (bolsa == null) {
            log.error("Bolsa no encontrada para el id: " + idBolsa);
            return "error";
        }
        model.addAttribute("bolsa", bolsa);
        model.addAttribute("cajas", cajaService.listarCajas());
        return "modificarBolsa";
    }
    
    @GetMapping("/eliminarBolsa/{idBolsa}")
    public String eliminarBolsa(@PathVariable("idBolsa") Long idBolsa) {
        Bolsa bolsa = bolsaService.encontrarBolsa(idBolsa);
        bolsaService.eliminarBolsa(bolsa);
        return "redirect:/bolsas";
    }
}