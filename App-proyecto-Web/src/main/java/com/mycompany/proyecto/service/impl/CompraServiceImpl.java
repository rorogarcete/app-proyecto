package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.CompraRepository;
import com.mycompany.proyecto.model.Compra;
import com.mycompany.proyecto.service.CompraService;

/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class CompraServiceImpl implements CompraService {
	
	private CompraRepository compraRepository;
	
	@Autowired
	public CompraServiceImpl(CompraRepository cr){
		this.compraRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Compra findById(Long codigo) throws DataAccessException {
		return compraRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compra> findByName(String nombre) throws DataAccessException {
		return compraRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Compra b) throws DataAccessException {
		compraRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Compra> getAll() throws DataAccessException {
		return compraRepository.findAll();
	}

	@Override
	@Transactional
	public Boolean remove(Compra c) throws DataAccessException {
		compraRepository.remove(c);
		return true;
	}

}
