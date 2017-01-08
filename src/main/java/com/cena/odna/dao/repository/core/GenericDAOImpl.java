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

    protected abstract Class<MODEL> getModelClass();

    @Override
    public MODEL findByPK(Long id) throws ManagerException {
        if (id == null) {
            throw new ManagerException("id mustn't be equals null");
        }
        logger.info(getModelClass().getSimpleName()+".findByPK({})", id);
        return entityManager.find(getModelClass(),id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MODEL> findAll() {
        logger.info(getModelClass().getSimpleName()+".findAll()");
        return entityManager.createQuery("select t from " + getModelClass().getSimpleName() + " t").getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MODEL> getByPKs(List<Long> pks) {
        logger.info(getModelClass().getSimpleName()+".findByPKs(), pks={}", pks);
        Query query = entityManager.createQuery(" select t from " + getModelClass().getSimpleName() + " t where t.id in :1");
        query.setParameter("1", pks);
        return query.getResultList();
    }

    @Override
    public void remove(Long id) throws ManagerException {
        if (id == null || id == 0) {
            throw new ManagerException("id mustn't be equals null");
        }
        logger.info(getModelClass().getSimpleName()+".remove() id={}", id);
        entityManager.remove(findByPK(id));
    }

    @Override
    public void insert(MODEL model) throws ManagerException {
        logger.info(getModelClass().getSimpleName()+".insert()");
        if (model == null) {
            throw new ManagerException("model mustn't be equals null");
        }
        entityManager.persist(model);
    }

    @Override
    public MODEL update(MODEL model) throws ManagerException {
        if (model == null) {
            throw new ManagerException("model mustn't be equals null");
        }
        logger.info(getModelClass().getSimpleName()+".update() id={}", model.getId());
        return entityManager.merge(model);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MODEL> find(int firstResult, int maxResult) {
        logger.info(getModelClass().getSimpleName()+".find({}, {})", firstResult, maxResult);
        return entityManager.createQuery("select t from " +
                getModelClass().getSimpleName() + " t where LIMIT " +
                maxResult + " OFFSET " + firstResult)
                .getResultList();
    }

    @Override
    public Long count() {
        logger.info(getModelClass().getSimpleName()+".count()");
        Query query = entityManager.createQuery("select count(t.id) from " + getModelClass().getSimpleName() + " t");
        return (Long) query.getSingleResult();
    }
}
