package com.cena.odna.core.mvc.controller.basket;

import com.cena.odna.core.mvc.service.basket.BasketService;
import com.cena.odna.core.mvc.service.core.page.Page;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dto.basket.BasketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 08.01.2017.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/api/basket")
public class BasketController {

    @Autowired
    private BasketService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasketDTO> getBasket(@PathVariable Long id) {
        BasketDTO basketDTO = null;
        try {
            basketDTO = service.findByPK(id);
        } catch (ManagerException e) {
            return new ResponseEntity<BasketDTO>(new BasketDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BasketDTO>(basketDTO, HttpStatus.OK);
    }

}
