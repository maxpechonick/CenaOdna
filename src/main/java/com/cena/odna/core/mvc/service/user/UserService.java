package com.cena.odna.core.mvc.service.user;


import com.cena.odna.core.mvc.service.core.GenericService;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dto.user.UserDTO;
import com.cena.odna.rest.file.PhotoUpload;

/**
 * Created by Admin on 21.12.2016.
 */
public interface UserService extends GenericService<UserDTO> {

    User findByUserName(String username);

    UserDTO getCurrentUser();

    UserDTO upload(PhotoUpload photoUpload);
}
