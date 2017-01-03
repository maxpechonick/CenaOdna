package com.cena.odna.core.config.security;

import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.repository.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 03.01.2017.
 */
@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserManager manager;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = manager.findByUserName(name);
        if (user == null) {
            throw new UsernameNotFoundException("no user find with name " + name);
        }
        return new AccountUserDetails(user);
    }
}
