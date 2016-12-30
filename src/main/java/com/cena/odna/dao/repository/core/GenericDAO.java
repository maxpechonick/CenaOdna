package com.cena.odna.dao.repository.core;

import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;

import java.util.List;

/**
 * Created by Admin on 12.12.2016.
 */
public interface GenericDAO<MODEL extends ModelObject> {

    MODEL findByPK(Long id) throws ManagerException;

    List<MODEL> findAll();

    List<MODEL> getByPKs(List<Long> pks);

    void remove(MODEL model) throws ManagerException;

    void insert(MODEL model) throws ManagerException;

    MODEL update(MODEL model) throws ManagerException;
}
