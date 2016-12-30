package com.cena.odna.core.service.user;

import com.cena.odna.core.service.core.GenericFacadeImpl;
import com.cena.odna.dao.model.entities.user.Role;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.model.entities.user.UserRole;
import com.cena.odna.dao.repository.user.UserManager;
import com.cena.odna.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

/**
 * Created by Admin on 30.12.2016.
 */
@Service
@Transactional
public class UserFacadeImpl extends GenericFacadeImpl<UserManager, UserDTO, User>
        implements UserFacade{

    @Autowired
    private UserManager manager;

    @Override
    protected UserManager getDAO() {
        return manager;
    }

    @Override
    public User convertToModel(UserDTO dto) {
        User result = new User();
        if (dto == null) {
            return result;
        }
        result.setId(dto.getId());
        result.setEnabled(dto.isEnabled());
        result.setUsername(dto.getUsername());
        //todo password and roles
        return result;
    }

    @Override
    public UserDTO convertToDTO(User user) {
        UserDTO result = new UserDTO();
        if (user == null) {
            return result;
        }
        result.setId(user.getId());
        result.setEnabled(user.isEnabled());
        result.setUsername(user.getUsername());
        result.setRoles(new ArrayList<Role>());
        for (UserRole role : user.getUserRole()) {
            result.getRoles().add(role.getRole());
        }
        return result;
    }

    @Override
    public User findByUserName(String username) {
        return manager.findByUserName(username);
    }
}
