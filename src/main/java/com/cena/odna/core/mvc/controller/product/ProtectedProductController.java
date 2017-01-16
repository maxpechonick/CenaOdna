package com.cena.odna.core.mvc.controller.product;

import com.cena.odna.core.mvc.service.exceptions.ServiceException;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dto.product.ProductDTO;
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
@RequestMapping("/api/protected/product")
public class ProtectedProductController extends ProductController {

    private final static Logger logger = LoggerFactory.getLogger(ProtectedProductController.class);

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody ProductDTO dto) {
        try {
            service.insert(dto);
        } catch (ServiceException e) {
            logger.error("error in ProductController.create()");
        }
    }

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductDTO> update(@RequestBody ProductDTO dto) {
        ProductDTO product = null;
        try {
            product = service.update(dto);
        } catch (ManagerException e) {
            logger.error("error in ProductController.update()");
        }
        return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        try {
            service.remove(id);
        } catch (ManagerException e) {
            logger.error("error in ProductController.delete()");
        }
    }
}
