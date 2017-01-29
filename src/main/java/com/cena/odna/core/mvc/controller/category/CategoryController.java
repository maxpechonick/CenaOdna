package com.cena.odna.core.mvc.controller.category;

import com.cena.odna.core.mvc.service.category.CategoryService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 22.12.2016.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {

    private final static Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    protected CategoryService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> result = service.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
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

}
