package com.cena.odna.core.service.user;

import com.cena.odna.core.service.core.GenericServiceImpl;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.repository.user.UserManager;
import com.cena.odna.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Admin on 21.12.2016.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<UserFacade, UserDTO>
        implements UserService{

    @Autowired
    private UserFacade facade;

    public User findByUserName(String username) {
        return facade.findByUserName(username);
    }

    @Override
    protected UserFacade getFacade() {
        return facade;
    }
}
