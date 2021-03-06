package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.PagoRepository;
import com.mycompany.proyecto.model.Pago;
import com.mycompany.proyecto.service.PagoService;
/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class PagoServiceImpl implements PagoService {
	
	private PagoRepository pagoRepository;
	
	@Autowired
	public PagoServiceImpl(PagoRepository pr){
		this.pagoRepository = pr;
	}

	@Override
	@Transactional(readOnly = true)
	public Pago findById(Long codigo) throws DataAccessException {
		return pagoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pago> findByName(String nombre) throws DataAccessException {
		return pagoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Pago b) throws DataAccessException {
		pagoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pago> getAll() throws DataAccessException {
		return pagoRepository.findAll();
	}

	@Override
	public Boolean remove(Pago c) throws DataAccessException {
		pagoRepository.remove(c);
		return true;
	}

}