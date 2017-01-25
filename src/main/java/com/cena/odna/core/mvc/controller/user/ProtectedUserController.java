package com.cena.odna.core.mvc.controller.user;

import com.cena.odna.core.mvc.service.core.page.Page;
import com.cena.odna.core.mvc.service.core.page.Pageable;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dto.user.UserDTO;
import com.cena.odna.rest.file.PhotoUpload;
import com.cena.odna.rest.file.PhotoUploadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Admin on 16.01.2017.
 */
@Controller
@CrossOrigin
@RequestMapping("/api/protected/user")
public class ProtectedUserController extends UserController {

    private static final Logger logger = LoggerFactory.getLogger(ProtectedUserController.class);

    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto) {
        UserDTO user = null;
        try {
            user = service.update(dto);
        } catch (ManagerException e) {
            logger.error("error in UserService.update()");
        }
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getCurrentUser() {
        UserDTO user = service.getCurrentUser();
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        try {
            service.remove(id);
        } catch (ManagerException e) {
            logger.error("error in UserController.delete()");
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO user = null;
        try {
            user = service.findByPK(id);
        } catch (ManagerException e) {
            return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable) {
        Page<UserDTO> all = service.findAll(pageable);
        return new ResponseEntity<Page<UserDTO>>(all, HttpStatus.OK);
    }

    @RequestMapping(value = "/upload", headers = ("content-type=multipart/*"), method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> uploadPhoto(@ModelAttribute PhotoUpload photoUpload, BindingResult result) {
        PhotoUploadValidator validator = new PhotoUploadValidator();
        validator.validate(photoUpload, result);
        UserDTO dto = service.upload(photoUpload);

        return new ResponseEntity<UserDTO>(dto, HttpStatus.OK);
    }
}
