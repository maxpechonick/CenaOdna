package com.cena.odna.core.service.core;

import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;
import com.cena.odna.dao.repository.core.GenericDAO;
import com.cena.odna.dto.core.AbstractDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 30.12.2016.
 */
public abstract class GenericFacadeImpl<DAO extends GenericDAO<MODEL>, DTO extends AbstractDTO, MODEL extends ModelObject>
        implements GenericFacade<DTO, MODEL> {

    protected abstract DAO getDAO();

    @Override
    public DTO findByPK(Long id) throws ManagerException {
        MODEL model = getDAO().findByPK(id);
        return convertToDTO(model);
    }

    @Override
    public List<DTO> findAll() {
        return convertToDTOList(getDAO().findAll());
    }

    @Override
    public List<DTO> getByPKs(List<Long> pks) {
        return convertToDTOList(getDAO().getByPKs(pks));
    }

    @Override
    public void remove(DTO dto) throws ManagerException {
        getDAO().remove(convertToModel(dto));
    }

    @Override
    public DTO update(DTO dto) throws ManagerException {
        return convertToDTO(getDAO().update(convertToModel(dto)));
    }

    @Override
    public void insert(DTO dto) throws ManagerException {
        getDAO().insert(convertToModel(dto));
    }

    protected List<MODEL> convertToModelList(List<DTO> dtoList) {
        List<MODEL> result = new ArrayList<MODEL>();
        for (DTO dto : dtoList) {
            result.add(convertToModel(dto));
        }
        return result;
    }

    protected List<DTO> convertToDTOList(List<MODEL> modelList) {
        List<DTO> result = new ArrayList<DTO>();
        for (MODEL model : modelList) {
            result.add(convertToDTO(model));
        }
        return result;
    }
}
