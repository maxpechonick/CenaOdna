package com.cena.odna.core.mvc.controller.product;

import com.cena.odna.core.mvc.service.core.page.Page;
import com.cena.odna.core.mvc.service.core.page.PageImpl;
import com.cena.odna.core.mvc.service.core.page.Pageable;
import com.cena.odna.core.mvc.service.product.ProductService;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dto.product.ProductDTO;
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
 * Created by Admin on 31.12.2016.
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    protected ProductService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {
        Page<ProductDTO> all = service.findAll(pageable);
        return new ResponseEntity<Page<ProductDTO>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO product = null;
        try {
            product = service.findByPK(id);
        } catch (ManagerException e) {
            return new ResponseEntity<ProductDTO>(new ProductDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<ProductDTO>> getAllForCategory(@PathVariable Long id, Pageable pageable) {
        List<ProductDTO> products = service.getAllForCategory(id);
        Page<ProductDTO> page = new PageImpl<ProductDTO>(products);
        return new ResponseEntity<Page<ProductDTO>>(page, HttpStatus.OK);
    }
}

