package com.cena.odna.core.service.core;

import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;
import com.cena.odna.dao.repository.core.GenericDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Admin on 21.12.2016.
 */
public abstract class GenericServiceImpl<DAO extends GenericDAO, MODEL extends ModelObject<PK>, PK>
        implements GenericService<DAO, MODEL, PK> {

    private static final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);

    protected abstract DAO getDAO();

    @SuppressWarnings("unchecked")
    public MODEL findByPK(PK id) throws ManagerException {
        return (MODEL) getDAO().findByPK(id);
    }

    @SuppressWarnings("unchecked")
    public List<MODEL> findAll() {
        return getDAO().findAll();
    }

    @SuppressWarnings("unchecked")
    public List<MODEL> getByPKs(List<PK> pks) {
        return getDAO().getByPKs(pks);
    }

    @SuppressWarnings("unchecked")
    public void remove(MODEL model) throws ManagerException {
        getDAO().remove(model);
    }

    @SuppressWarnings("unchecked")
    public void insert(MODEL model) throws ManagerException {
        getDAO().insert(model);
    }

    @SuppressWarnings("unchecked")
    public MODEL update(MODEL model) throws ManagerException {
        return (MODEL) getDAO().update(model);
    }
}
