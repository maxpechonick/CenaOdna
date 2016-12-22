package com.cena.odna.core.service.user;


import com.cena.odna.core.service.core.GenericService;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.repository.user.UserManager;

/**
 * Created by Admin on 21.12.2016.
 */
public interface UserService extends GenericService<UserManager, User, Long> {

    User findByUserName(String username);

}
