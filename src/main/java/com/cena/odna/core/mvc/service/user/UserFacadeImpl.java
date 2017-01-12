package com.cena.odna.core.mvc.service.user;

import com.cena.odna.core.mvc.service.core.GenericFacadeImpl;
import com.cena.odna.core.mvc.service.exceptions.ServiceException;
import com.cena.odna.dao.exceptions.ManagerException;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.repository.user.UserManager;
import com.cena.odna.dto.user.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private static final Logger logger = LoggerFactory.getLogger(UserFacadeImpl.class);

    @Autowired
    private UserManager manager;

    @Autowired
    private BCryptPasswordEncoder encoder;

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
        result.setFirstName(dto.getFirstName());
        result.setLastName(dto.getLastName());
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
        result.setFirstName(user.getFirstName());
        result.setLastName(user.getLastName());
        return result;
    }

    @Override
    public void insert(UserDTO dto) throws ServiceException {
        User user = convertToModel(dto);
        User userByName = findByUserName(user.getUsername());
        if (userByName != null) {
            throw new ServiceException("user with name '" + user.getUsername() + "' already exist");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            getDAO().insert(user);
        } catch (ManagerException e) {
            logger.error("error in UserManager.insert", e);
        }
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
