package com.mycompany.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.dao.CategoriaRepository;
import com.mycompany.proyecto.model.Categoria;
import com.mycompany.proyecto.service.CategoriaService;
/**
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaServiceImpl(CategoriaRepository cr){
		this.categoriaRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria findById(Long codigo) throws DataAccessException {
		return categoriaRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> findByName(String nombre) throws DataAccessException {
		return categoriaRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Categoria b) throws DataAccessException {
		categoriaRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> getAll() throws DataAccessException {
		return categoriaRepository.findAll();
	}

	@Override
	public Boolean remove(Categoria c) throws DataAccessException {
		categoriaRepository.remove(c);
		return true;
	}

}