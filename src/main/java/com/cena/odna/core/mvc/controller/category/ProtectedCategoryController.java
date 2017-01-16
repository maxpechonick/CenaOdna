package com.cena.odna.core.mvc.controller.category;

import com.cena.odna.core.mvc.service.exceptions.ServiceException;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dto.category.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 16.01.2017.
 */
@Controller
@CrossOrigin
@RequestMapping("/api/protected/category")
public class ProtectedCategoryController extends CategoryController {

    private final static Logger logger = LoggerFactory.getLogger(ProtectedCategoryController.class);

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody CategoryDTO dto) {
        try {
            service.insert(dto);
        } catch (ServiceException e) {
            logger.error("error in CategoryController.create");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO dto) {
        CategoryDTO category = null;
        try {
            category = service.update(dto);
        } catch (ManagerException e) {
            logger.error("error in CategoryController.update()");
        }
        return new ResponseEntity<CategoryDTO>(category, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        try {
            service.remove(id);
        } catch (ManagerException e) {
            logger.error("error in CategoryController.remove()");
        }
    }

}
