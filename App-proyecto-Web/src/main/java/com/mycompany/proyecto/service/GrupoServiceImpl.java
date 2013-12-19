package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Grupo;
import com.mycompany.proyecto.repository.GrupoRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class GrupoServiceImpl implements GrupoService {
	
	private GrupoRepository grupoRepository;
	
	@Autowired
	public GrupoServiceImpl(GrupoRepository br){
		this.grupoRepository = br;
	}

	@Override
	@Transactional(readOnly = true)
	public Grupo findById(Long codigo) throws DataAccessException {
		return grupoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> findByName(String nombre) throws DataAccessException {
		return grupoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Grupo g) throws DataAccessException {
		grupoRepository.save(g);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Grupo> getAll() throws DataAccessException {
		return grupoRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Grupo c) throws DataAccessException {
		grupoRepository.remove(c);
		return true;
	}

}
