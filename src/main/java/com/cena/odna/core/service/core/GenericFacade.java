package com.cena.odna.core.service.core;

import com.cena.odna.core.service.core.page.Page;
import com.cena.odna.core.service.core.page.Pageable;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.core.ModelObject;
import com.cena.odna.dto.core.AbstractDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 30.12.2016.
 */
public interface GenericFacade<DTO extends AbstractDTO, MODEL extends ModelObject> extends Serializable {

    DTO findByPK(Long id) throws ManagerException;
    List<DTO> findAll();
    List<DTO> getByPKs(List<Long> pks);
    void remove(Long id) throws ManagerException;
    DTO update(DTO dto) throws ManagerException;
    void insert(DTO dto) throws ManagerException;
    Page<DTO> findAll(Pageable pageable);
    MODEL convertToModel(DTO dto);
    DTO convertToDTO(MODEL model);
    List<DTO> convertToDTOList(List<MODEL> modelList);
    List<MODEL> convertToModelList(List<DTO> DTOList);

}
