/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thomas.servicio;
import java.util.List;
import com.thomas.domain.Documento;

/**
 *
 * @author sergio
 */
public interface DocumentoService {
   public List<Documento> listarDocumentos();
    
    public void guardarDocumento(Documento documento);
    
    public void eliminarDocumento(Documento documento);
    
    public Documento encontrarDocumento(Long idDocumento); 
}
