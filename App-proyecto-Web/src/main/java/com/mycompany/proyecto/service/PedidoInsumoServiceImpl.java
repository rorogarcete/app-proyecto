package com.mycompany.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.proyecto.model.Insumo;
import com.mycompany.proyecto.model.Pedido;
import com.mycompany.proyecto.repository.PedidoRepository;

/**
 * Mostly used as a facade for all Petclinic controllers
 * Also a placeholder for @Transactional and @Cacheable annotations
 *
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2012
 */
@Service
public class PedidoInsumoServiceImpl implements PedidoInsumoService {
	
	private PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoInsumoServiceImpl(PedidoRepository cr){
		this.pedidoRepository = cr;
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido findById(Long codigo) throws DataAccessException {
		return pedidoRepository.findById(codigo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> findByName(String nombre) throws DataAccessException {
		return pedidoRepository.findByName(nombre);
	}

	@Override
	@Transactional
	public void save(Pedido b) throws DataAccessException {
		pedidoRepository.save(b);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> getAll() throws DataAccessException {
		return pedidoRepository.getAll();
	}

	@Override
	public Boolean remove(Pedido c) throws DataAccessException {
		pedidoRepository.remove(c);
		return true;
	}

	@Override
	public List<Insumo> getInsumos() throws DataAccessException {
		return pedidoRepository.getInsumos();
	}

}
