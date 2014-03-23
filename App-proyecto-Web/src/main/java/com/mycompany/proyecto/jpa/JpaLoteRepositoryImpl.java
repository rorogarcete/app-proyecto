package com.mycompany.proyecto.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import com.mycompany.proyecto.model.Lote;
import com.mycompany.proyecto.repository.BaseDao;
import com.mycompany.proyecto.repository.LoteRepository;
/**
 * Implementacion de JPA de la interfaz {@link LoteRepository}
 * @author Rodrigo Garcete
 * @since 21/11/2013
 */
@Repository
public class JpaLoteRepositoryImpl extends BaseDao<Lote, Serializable> implements LoteRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Lote> findByName(String nombre) throws DataAccessException {
        Query query = this.entityManager.createNamedQuery("Lote.findByName");
        query.setParameter("nombre", nombre + "%");
        return (List<Lote>)query.getResultList();
	}

}