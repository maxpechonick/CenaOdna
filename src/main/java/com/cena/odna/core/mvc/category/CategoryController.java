package com.cena.odna.core.mvc.category;

import com.cena.odna.dto.category.CategoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoryDTO>> findAllPersons() {
        return null;
    }

}
