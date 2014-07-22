package com.mycompany.proyecto.service;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mycompany.proyecto.model.Operacion;

/**
 * Contrato de Persistencia para la entidad <code>Insumo</code>
 * Define las operaciones basicas de registro (CRUD), siguiendo el patron
 * de diseño <code>Data Access Object</code>
 *  
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
public interface OperacionService {

	Operacion findById(Long codigo) throws DataAccessException;
	
	List<Operacion> findByName(String nombre) throws DataAccessException; 

	List<Operacion> getAll() throws DataAccessException;
		
	void save(Operacion operacion) throws DataAccessException;
		
	Boolean remove(Operacion operacion) throws DataAccessException;
	
}