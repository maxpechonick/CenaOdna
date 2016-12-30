package com.cena.odna.dao.repository.core;

import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Admin on 12.12.2016.
 */
public abstract class GenericDAOImpl<MODEL extends ModelObject> implements GenericDAO<MODEL> {

    private static final Logger logger = LoggerFactory.getLogger(GenericDAOImpl.class);

    @PersistenceContext
    protected EntityManager entityManager;

    protected abstract Class<MODEL> getClazz();

    public MODEL findByPK(Long id) throws ManagerException {
        if (id == null) {
            throw new ManagerException("id mustn't be equals null");
        }
        logger.info(getClazz().getSimpleName()+".findByPK({})", id);
        return entityManager.find(getClazz(),id);
    }

    @SuppressWarnings("unchecked")
    public List<MODEL> findAll() {
        logger.info(getClazz().getSimpleName()+".findAll()");
        return entityManager.createQuery("select t from " + getClazz().getSimpleName() + " t").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<MODEL> getByPKs(List<Long> pks) {
        logger.info(getClazz().getSimpleName()+".findByPKs(), pks={}", pks);
        Query query = entityManager.createQuery(" select t from " + getClazz().getSimpleName() + " t where t.id in :1");
        query.setParameter("1", pks);
        return query.getResultList();
    }

    public void remove(MODEL model) throws ManagerException {
        if (model == null) {
            throw new ManagerException("model mustn't be equals null");
        }
        logger.info(getClazz().getSimpleName()+".remove() id={}", model.getId());
        entityManager.remove(model);
    }

    public void insert(MODEL model) throws ManagerException {
        logger.info(getClazz().getSimpleName()+".insert()");
        if (model == null) {
            throw new ManagerException("model mustn't be equals null");
        }
        entityManager.persist(model);
    }

    public MODEL update(MODEL model) throws ManagerException {
        if (model == null) {
            throw new ManagerException("model mustn't be equals null");
        }
        logger.info(getClazz().getSimpleName()+".update() id={}", model.getId());
        return entityManager.merge(model);
    }

}
