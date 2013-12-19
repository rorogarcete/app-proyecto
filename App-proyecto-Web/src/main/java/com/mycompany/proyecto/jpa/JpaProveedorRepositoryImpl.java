package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.mycompany.proyecto.model.Proveedor;
import com.mycompany.proyecto.repository.ProveedorRepository;

/**
 * Implementacion de JPA de la interfaz {@link InusmoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaProveedorRepositoryImpl implements ProveedorRepository {
	
	@PersistenceContext
	private EntityManager em = null;

    @Override
	public Proveedor findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT p FROM Proveedor p WHERE p.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Proveedor) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> findByName(String nombre) throws DataAccessException {
		// using 'join fetch' because a single query should load both owners and pets
        // using 'left join fetch' because it might happen that an owner does not have pets yet
        Query query = this.em.createQuery("SELECT i FROM Proveedor i WHERE i.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Proveedor>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> getAll() throws DataAccessException {
		return (List<Proveedor>)em.createQuery("select i from Proveedor i order by i.codigo").getResultList();
	}

	@Override
	public void save(Proveedor proveedor) throws DataAccessException {
    	if (proveedor.getCodigo() == null) {
    		this.em.persist(proveedor);
        	this.em.flush();
		} else {
			this.em.merge(proveedor);
	    	this.em.flush();
		}
		
	}

	@Override
	public Boolean remove(Proveedor proveedor) throws DataAccessException {
		this.em.remove(em.contains(proveedor) ? proveedor : em.merge(proveedor));
		return true;
	}

}