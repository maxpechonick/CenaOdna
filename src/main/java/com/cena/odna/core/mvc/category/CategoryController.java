package com.cena.odna.core.mvc.category;

import com.cena.odna.core.service.category.CategoryService;
import com.cena.odna.core.service.core.page.Page;
import com.cena.odna.core.service.core.page.Pageable;
import com.cena.odna.dto.category.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
