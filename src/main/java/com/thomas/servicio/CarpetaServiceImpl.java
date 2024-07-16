/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.servicio;

import java.util.List;
import com.thomas.dao.CarpetaDao;
import com.thomas.domain.Carpeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sergio
 */
@Service
public class CarpetaServiceImpl implements CarpetaService {

    @Autowired
    private CarpetaDao carpetaDao;
    
    @Transactional(readOnly = true)
    @Override
    public List<Carpeta> listarCarpetas() {
        return (List<Carpeta>) carpetaDao.findAll();
    }

    @Transactional
    @Override
    public void guardarCarpeta(Carpeta carpeta) {
        carpetaDao.save(carpeta);
    }

    @Transactional
    @Override
    public void eliminarCarpeta(Carpeta carpeta) {
        carpetaDao.delete(carpeta);
    }

    @Transactional(readOnly = true)
    @Override
    public Carpeta encontrarCarpeta(Long idCarpeta) {
        return carpetaDao.findById(idCarpeta).orElse(null);
    }
}
