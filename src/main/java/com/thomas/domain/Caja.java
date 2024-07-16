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
@Table(name = "caja")
public class Caja implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCaja;
    
    private String codigo;
    
    @OneToMany(mappedBy = "caja", cascade = CascadeType.ALL)
    private List<Bolsa> bolsas;
    
     @Override
    public String toString() {
        return "Caja{" +
               "idCaja=" + idCaja +
               ", codigo='" + codigo + '\'' +
               '}';
    }
    
}
