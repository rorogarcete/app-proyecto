package com.mycompany.proyecto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.dao.EgresoRepository;
import com.mycompany.proyecto.model.Egreso;
import com.mycompany.proyecto.service.EgresoService;
/**
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class EgresoServiceImpl implements EgresoService {
	
	private EgresoRepository egresoRepository;
	
	@Autowired
	public EgresoServiceImpl(EgresoRepository er){
		this.egresoRepository = er;
	}

	@Override
	@Transactional(readOnly = true)
	public Egreso findById(Long codigo) throws DataAccessException {
		return egresoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Egreso> findByName(String nombre) throws DataAccessException {
		return egresoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Egreso b) throws DataAccessException {
		egresoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Egreso> getAll() throws DataAccessException {
		return egresoRepository.findAll();
	}

	@Override
	public Boolean remove(Egreso c) throws DataAccessException {
		egresoRepository.remove(c);
		return true;
	}

}