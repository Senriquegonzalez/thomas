/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thomas.servicio;

import java.util.List;
import com.thomas.dao.DocumentoDao;
import com.thomas.domain.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sergio
 */
@Service
public class DocumentoServiceImpl implements DocumentoService {

    @Autowired
    private DocumentoDao documentoDao;
    
    @Transactional(readOnly = true)
    @Override
    public List<Documento> listarDocumentos() {
        return (List<Documento>) documentoDao.findAll();
    }

    @Transactional
    @Override
    public void guardarDocumento(Documento documento) {
        documentoDao.save(documento);
    }

    @Transactional
    @Override
    public void eliminarDocumento(Documento documento) {
        documentoDao.delete(documento);
    }

    @Transactional(readOnly = true)
    @Override
    public Documento encontrarDocumento(Long idDocumento) {
        return documentoDao.findById(idDocumento).orElse(null);
    }
}
