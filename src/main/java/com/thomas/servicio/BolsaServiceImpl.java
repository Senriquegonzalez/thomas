/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.servicio;

import java.util.List;
import com.thomas.dao.BolsaDao;
import com.thomas.domain.Bolsa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sergio
 */
@Service
public class BolsaServiceImpl implements BolsaService {

    @Autowired
    private BolsaDao bolsaDao;
    
    @Transactional(readOnly = true)
    @Override
    public List<Bolsa> listarBolsas() {
        return (List<Bolsa>) bolsaDao.findAll();
    }

    @Transactional
    @Override
    public void guardarBolsa(Bolsa bolsa) {
        bolsaDao.save(bolsa);
    }

    @Transactional
    @Override
    public void eliminarBolsa(Bolsa bolsa) {
        bolsaDao.delete(bolsa);
    }

    @Transactional(readOnly = true)
    @Override
    public Bolsa encontrarBolsa(Long idBolsa) {
        return bolsaDao.findById(idBolsa).orElse(null);
    }
}
