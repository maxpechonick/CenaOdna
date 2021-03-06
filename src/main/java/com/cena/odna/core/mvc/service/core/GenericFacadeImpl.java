package com.cena.odna.core.mvc.service.core;

import com.cena.odna.core.mvc.service.core.page.Page;
import com.cena.odna.core.mvc.service.core.page.PageImpl;
import com.cena.odna.core.mvc.service.core.page.Pageable;
import com.cena.odna.core.mvc.service.exceptions.ServiceException;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;
import com.cena.odna.dao.repository.core.GenericDAO;
import com.cena.odna.dto.core.AbstractDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 30.12.2016.
 */
public abstract class GenericFacadeImpl<DAO extends GenericDAO<MODEL>, DTO extends AbstractDTO, MODEL extends ModelObject>
        extends SessionFacadeImpl
        implements GenericFacade<DTO, MODEL> {

    private static final Logger logger = LoggerFactory.getLogger(GenericFacadeImpl.class);

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
    public void remove(Long id) throws ManagerException {
        if (!isAdmin()) return;
        getDAO().remove(id);
    }

    @Override
    public DTO update(DTO dto) throws ManagerException {
        if (!isAdmin()) return null;
        return convertToDTO(getDAO().update(convertToModel(dto)));
    }

    @Override
    public void insert(DTO dto) throws ServiceException {
        if (!isAdmin()) return;
        try {
            getDAO().insert(convertToModel(dto));
        } catch (ManagerException e) {
            logger.error("error in " + getDAO().getClass().getSimpleName() + ".insert", e);
        }
    }

    public List<MODEL> convertToModelList(List<DTO> dtoList) {
        List<MODEL> result = new ArrayList<MODEL>();
        for (DTO dto : dtoList) {
            result.add(convertToModel(dto));
        }
        return result;
    }

    public List<DTO> convertToDTOList(List<MODEL> modelList) {
        List<DTO> result = new ArrayList<DTO>();
        for (MODEL model : modelList) {
            result.add(convertToDTO(model));
        }
        return result;
    }

    @Override
    public Page<DTO> findAll(Pageable pageable) {
        if (pageable == null || pageable.toString().equals("{}")) {
            return new PageImpl<DTO>(findAll());
        }

        return readPage(pageable);
    }

    private Page<DTO> readPage(Pageable pageable) {
        long total = getDAO().count();
        List<DTO> content = pageable.getOffset() > total ?
                Collections.<DTO>emptyList() :
                convertToDTOList(getDAO().find(pageable.getOffset(), pageable.getPageSize()));
        return new PageImpl<DTO>(content, pageable, total);
    }
}
