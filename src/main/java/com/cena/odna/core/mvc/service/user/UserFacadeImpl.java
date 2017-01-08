package com.cena.odna.core.mvc.service.user;

import com.cena.odna.core.mvc.service.core.GenericFacadeImpl;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.repository.user.UserManager;
import com.cena.odna.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Admin on 30.12.2016.
 */
@Service
@Transactional
public class UserFacadeImpl extends GenericFacadeImpl<UserManager, UserDTO, User>
        implements UserFacade {

    @Autowired
    private UserManager manager;

    @Autowired
    private PasswordEncoder encoder;

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
        result.setRole(dto.getRole());
        result.setPassword(dto.getPassword());
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
        result.setRole(user.getRole());
        return result;
    }

    @Override
    public void insert(UserDTO dto) throws ManagerException {
        User user = convertToModel(dto);
        user.setPassword(encoder.encode(user.getPassword()));
        getDAO().insert(user);
    }

    @Override
    public UserDTO update(UserDTO dto) throws ManagerException {
        User user = convertToModel(dto);
        if (user.getPassword() == null) {
            User currentUser = getDAO().findByPK(user.getId());
            user.setPassword(currentUser.getPassword());
        }
        return convertToDTO(manager.update(user));
    }

    @Override
    public User findByUserName(String username) {
        return manager.findByUserName(username);
    }
}
