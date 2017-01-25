package com.cena.odna.core.mvc.service.user;

import com.cena.odna.core.mvc.service.core.GenericServiceImpl;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dto.user.UserDTO;
import com.cena.odna.rest.file.PhotoUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 21.12.2016.
 */
@Service
public class UserServiceImpl extends GenericServiceImpl<UserFacade, UserDTO>
        implements UserService {

    @Autowired
    private UserFacade facade;

    public User findByUserName(String username) {
        return facade.findByUserName(username);
    }

    @Override
    public UserDTO getCurrentUser() {
        return facade.convertToDTO(facade.getAuthenticatedUser());
    }

    @Override
    protected UserFacade getFacade() {
        return facade;
    }

    @Override
    public UserDTO upload(PhotoUpload photoUpload) {
        User user = null;
        try {
            user = facade.upload(photoUpload);
        } catch (ManagerException e) {
            e.printStackTrace();
        }
        return facade.convertToDTO(user);
    }
}
