package com.cena.odna.core.service.user;

import com.cena.odna.core.service.core.GenericServiceImpl;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.repository.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Admin on 21.12.2016.
 */
@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<UserManager, User, Long>
        implements UserService{

    @Autowired
    private UserManager userManager;

    protected UserManager getDAO() {
        return userManager;
    }

    public User findByUserName(String username) {
        return userManager.findByUserName(username);
    }
}
