/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author sergio
 */
@Data
@Entity
@Table(name = "bolsa")
public class Bolsa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBolsa;
    
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "id_caja")
    private Caja caja;
    
    @OneToMany(mappedBy = "bolsa", cascade = CascadeType.ALL)
    private List<Carpeta> carpetas;
       @Override
    public String toString() {
        return "Bolsa{" +
               "idBolsa=" + idBolsa +
               ", codigo='" + codigo + '\'' +
               
               '}';
    }
    
    
}
