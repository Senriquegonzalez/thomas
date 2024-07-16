/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.domain;

import javax.validation.constraints.NotNull;
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
@Table(name = "carpeta")
public class Carpeta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarpeta;
    
    private String codigo;
    
    @NotNull(message = "La bolsa no puede ser nula")
    @ManyToOne
    @JoinColumn(name = "id_bolsa")
    private Bolsa bolsa;
    
    @OneToMany(mappedBy = "carpeta", cascade = CascadeType.ALL)
    private List<Documento> documentos;
    @Override
    public String toString() {
        return "Carpeta{" +
               "idCarpeta=" + idCarpeta +
               ", codigo='" + codigo + '\'' +
               '}';
    }

    
   
}
