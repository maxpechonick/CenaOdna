package com.cena.odna.dao.repository.user;

import com.cena.odna.dao.repository.core.GenericDAOImpl;
import com.cena.odna.dao.model.entities.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 12.12.2016.
 */
@Repository
public class UserManagerImpl extends GenericDAOImpl<User, Long> implements UserManager {

    public User findByUserName(String username) {
        return null;
    }

    protected Class<User> getClazz() {
        return User.class;
    }
}
