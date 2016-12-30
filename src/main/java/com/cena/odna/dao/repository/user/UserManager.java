package com.cena.odna.dao.repository.user;


import com.cena.odna.dao.repository.core.GenericDAO;
import com.cena.odna.dao.model.entities.user.User;

/**
 * Created by Admin on 12.12.2016.
 */
public interface UserManager extends GenericDAO<User> {
    User findByUserName(String username);
}
