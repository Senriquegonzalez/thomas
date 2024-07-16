/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.web;

import com.thomas.domain.Carpeta;
import com.thomas.domain.Documento;
import com.thomas.servicio.CarpetaService;
import com.thomas.servicio.DocumentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class ControladorDocumento {

    @Autowired
    private DocumentoService documentoService;
    
    @Autowired
    private CarpetaService carpetaService;
    
    @GetMapping("/documentos")
    public String listarDocumentos(Model model) {
        var documentos = documentoService.listarDocumentos();
        model.addAttribute("documentos", documentos);
        return "documentos";
    }
    
    @GetMapping("/agregarDocumento")
    public String agregarDocumento(Documento documento, Model model) {
        model.addAttribute("carpetas", carpetaService.listarCarpetas());
        return "modificarDocumento";
    }
    
    @PostMapping("/guardarDocumento")
    public String guardarDocumento(Documento documento) {
        documentoService.guardarDocumento(documento);
        return "redirect:/documentos";
    }
    
    @GetMapping("/editarDocumento/{idDocumento}")
    public String editarDocumento(@PathVariable("idDocumento") Long idDocumento, Model model) {
        Documento documento = documentoService.encontrarDocumento(idDocumento);
        if (documento == null) {
            log.error("Documento no encontrado para el id: " + idDocumento);
            return "error";
        }
        model.addAttribute("documento", documento);
        model.addAttribute("carpetas", carpetaService.listarCarpetas());
        return "modificarDocumento";
    }
    
    @GetMapping("/eliminarDocumento/{idDocumento}")
    public String eliminarDocumento(@PathVariable("idDocumento") Long idDocumento) {
        Documento documento = documentoService.encontrarDocumento(idDocumento);
        documentoService.eliminarDocumento(documento);
        return "redirect:/documentos";
    }
}