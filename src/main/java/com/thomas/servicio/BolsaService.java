/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thomas.servicio;
import java.util.List;
import com.thomas.domain.Bolsa;

/**
 *
 * @author sergio
 */
public interface BolsaService {
 public List<Bolsa> listarBolsas();
    
    public void guardarBolsa(Bolsa bolsa);
    
    public void eliminarBolsa(Bolsa bolsa);
    
    public Bolsa encontrarBolsa(Long idBolsa);
}   

