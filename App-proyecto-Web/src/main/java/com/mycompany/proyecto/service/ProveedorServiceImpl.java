
package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mycompany.proyecto.model.Proveedor;
import com.mycompany.proyecto.repository.ProveedorRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	private ProveedorRepository proveedorRepository;
	
	@Autowired
	public ProveedorServiceImpl(ProveedorRepository ir){
		this.proveedorRepository = ir;
	}

	@Override
	@Transactional(readOnly = true)
	public Proveedor findById(Long codigo) throws DataAccessException {
		return proveedorRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> findByName(String nombre) throws DataAccessException {
		return proveedorRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Proveedor p) throws DataAccessException {
		proveedorRepository.save(p);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Proveedor> getAll() throws DataAccessException {
		return proveedorRepository.getAll();
	}

	@Override
	@Transactional
	public Boolean remove(Proveedor p) throws DataAccessException {
		proveedorRepository.remove(p);
		return true;
	}

}
