package com.cena.odna.core.service.core;

import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;
import com.cena.odna.dto.core.AbstractDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Admin on 21.12.2016.
 */
public abstract class GenericServiceImpl<F extends GenericFacade, DTO extends AbstractDTO>
        implements GenericService< DTO> {

    private static final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);

    protected abstract F getFacade();

    @SuppressWarnings("unchecked")
    public DTO findByPK(Long id) throws ManagerException {
        return (DTO) getFacade().findByPK(id);
    }

    @SuppressWarnings("unchecked")
    public List<DTO> findAll() {
        return getFacade().findAll();
    }

    @SuppressWarnings("unchecked")
    public List<DTO> getByPKs(List<Long> pks) {
        return getFacade().getByPKs(pks);
    }

    @SuppressWarnings("unchecked")
    public void remove(DTO dto) throws ManagerException {
        getFacade().remove(dto);
    }

    @SuppressWarnings("unchecked")
    public void insert(DTO dto) throws ManagerException {
        getFacade().insert(dto);
    }

    @SuppressWarnings("unchecked")
    public DTO update(DTO dto) throws ManagerException {
        return (DTO) getFacade().update(dto);
    }
}
