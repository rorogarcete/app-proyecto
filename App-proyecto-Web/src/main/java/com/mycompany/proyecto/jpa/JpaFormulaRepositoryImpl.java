package com.mycompany.proyecto.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Formula;
import com.mycompany.proyecto.repository.BancoRepository;
import com.mycompany.proyecto.repository.FormulaRepository;

/**
 * Implementacion de JPA de la interfaz {@link BancoRepository}
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */
@Repository
public class JpaFormulaRepositoryImpl implements FormulaRepository {
	
	@PersistenceContext
	private EntityManager em;

    @Override
	public Formula findById(Long codigo) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Formula b WHERE b.codigo =:codigo");
        query.setParameter("codigo", codigo);
        return (Formula)query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Formula> findByName(String nombre) throws DataAccessException {
        Query query = this.em.createQuery("SELECT b FROM Formula b WHERE b.nombre LIKE :nombre");
        query.setParameter("nombre", nombre + "%");
        return (List<Formula>)query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Formula> getAll() throws DataAccessException {
		return (List<Formula>)em.createQuery("SELECT f FROM Formula f order by f.codigo").getResultList();
	}

	@Override
	public void save(Formula c) throws DataAccessException {
		if(c.getCodigo() == null){
			this.em.persist(c);
		}else {
			this.em.merge(c);
		}
		this.em.flush();
	}

	@Override
	public Boolean remove(Formula c) throws DataAccessException {
		this.em.remove(em.contains(c) ? c : em.merge(c));
		return true;
	}

}