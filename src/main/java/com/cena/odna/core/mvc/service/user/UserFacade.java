package com.cena.odna.core.mvc.service.user;

import com.cena.odna.core.mvc.service.core.GenericFacade;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dto.user.UserDTO;

/**
 * Created by Admin on 30.12.2016.
 */
public interface UserFacade extends GenericFacade<UserDTO, User> {

    User findByUserName(String username);

}
