/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.servicio;
import java.util.List;
import com.thomas.dao.CajaDao;
import com.thomas.domain.Caja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sergio
 */
@Service
public class CajaServiceImpl implements CajaService {

    @Autowired
    private CajaDao cajaDao;
    
    @Transactional(readOnly = true)
    @Override
    public List<Caja> listarCajas() {
        return (List<Caja>) cajaDao.findAll();
    }

    @Transactional
    @Override
    public void guardarCaja(Caja caja) {
        cajaDao.save(caja);
    }

    @Transactional
    @Override
    public void eliminarCaja(Caja caja) {
        cajaDao.delete(caja);
    }

    @Transactional(readOnly = true)
    @Override
    public Caja encontrarCaja(Long idCaja) {
        return cajaDao.findById(idCaja).orElse(null);
    }
}
