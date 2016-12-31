package com.cena.odna.core.mvc.category;

import com.cena.odna.core.service.category.CategoryService;
import com.cena.odna.core.service.core.page.Page;
import com.cena.odna.core.service.core.page.Pageable;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dto.category.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 22.12.2016.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    private final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CategoryDTO>> findAllPersons(Pageable pageable) {
        Page<CategoryDTO> result = service.findAll(pageable);
        return new ResponseEntity<Page<CategoryDTO>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) {
        CategoryDTO result;
        try {
            result = service.findByPK(id);
        } catch (ManagerException e) {
            return new ResponseEntity<CategoryDTO>(new CategoryDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CategoryDTO>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody CategoryDTO dto) {
        try {
            service.insert(dto);
        } catch (ManagerException e) {
            logger.error("error in CategoryController.create");
        }
    }

    @RequestMapping(value = "" , method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody CategoryDTO dto) {
        try {
            service.update(dto);
        } catch (ManagerException e) {
            logger.error("error in CategoryController.update()");
        }
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        try {
            service.remove(id);
        } catch (ManagerException e) {
            logger.error("CategoryController.remove()");
        }
    }

}
