package com.cena.odna.core.mvc.controller.user;

import com.cena.odna.core.mvc.service.exceptions.ServiceException;
import com.cena.odna.core.mvc.service.user.UserService;
import com.cena.odna.dao.model.entities.user.Role;
import com.cena.odna.dto.user.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 06.01.2017.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    protected UserService service;

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> create(@RequestBody UserDTO dto) {
        dto.setRole(Role.USER);
        dto.setEnabled(true);
        try {
            service.insert(dto);
        } catch (ServiceException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>("OK", HttpStatus.OK);
    }

}

