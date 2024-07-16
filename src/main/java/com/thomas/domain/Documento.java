/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author sergio
 */
@Data
@Entity
@Table(name = "documento")
public class Documento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;
    
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "id_carpeta")
    private Carpeta carpeta;
    
    @Override
    public String toString() {
        return "Documento{" +
               "idDocumento=" + idDocumento +
              ", codigo='" + codigo + '\'' +
               '}';
    }
    
    
}