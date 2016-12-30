package com.cena.odna.core.service.core;

import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;
import com.cena.odna.dao.repository.core.GenericDAO;
import com.cena.odna.dto.core.AbstractDTO;

import java.util.List;

/**
 * Created by Admin on 30.12.2016.
 */
public interface GenericFacade<DTO extends AbstractDTO, MODEL extends ModelObject> {

    DTO findByPK(Long id) throws ManagerException;
    List<DTO> findAll();
    List<DTO> getByPKs(List<Long> pks);
    void remove(DTO dto) throws ManagerException;
    DTO update(DTO dto) throws ManagerException;
    void insert(DTO dto) throws ManagerException;

    MODEL convertToModel(DTO dto);
    DTO convertToDTO(MODEL model);

}
