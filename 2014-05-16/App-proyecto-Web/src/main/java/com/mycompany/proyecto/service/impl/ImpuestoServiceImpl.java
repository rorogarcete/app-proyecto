package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.ImpuestoRepository;
import com.mycompany.proyecto.model.Impuesto;
import com.mycompany.proyecto.service.ImpuestoService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ImpuestoServiceImpl implements ImpuestoService {
	
	private ImpuestoRepository impuestoRepository;
	
	@Autowired
	public ImpuestoServiceImpl(ImpuestoRepository ir){
		this.impuestoRepository = ir;
	}

	@Override
	@Transactional(readOnly = true)
	public Impuesto findById(Long codigo) throws DataAccessException {
		return impuestoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Impuesto> findByName(String nombre) throws DataAccessException {
		return impuestoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Impuesto b) throws DataAccessException {
		impuestoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Impuesto> getAll() throws DataAccessException {
		return impuestoRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Impuesto c) throws DataAccessException {
		impuestoRepository.remove(c);
		return true;
	}

	@Override
	public List<Impuesto> findByCombo() throws DataAccessException {
		return impuestoRepository.findByCombo();
	}

}
