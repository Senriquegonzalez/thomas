/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thomas.servicio;
import java.util.List;
import com.thomas.domain.Carpeta;
/**
 *
 * @author sergio
 */
public interface CarpetaService {
 public List<Carpeta> listarCarpetas();
    
    public void guardarCarpeta(Carpeta carpeta);
    
    public void eliminarCarpeta(Carpeta carpeta);
    
    public Carpeta encontrarCarpeta(Long idCarpeta);   
}
