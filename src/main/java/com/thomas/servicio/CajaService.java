/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thomas.servicio;
import java.util.List;
import com.thomas.domain.Caja;

/**
 *
 * @author sergio
 */
public interface CajaService {
    
    public List<Caja> listarCajas();
    
    public void guardarCaja(Caja caja);
    
    public void eliminarCaja(Caja caja);
    
    public Caja encontrarCaja(Long idCaja);
}
