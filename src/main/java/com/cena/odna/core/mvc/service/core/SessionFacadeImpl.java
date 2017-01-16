package com.cena.odna.core.mvc.service.core;

import com.cena.odna.core.config.security.model.UserContext;
import com.cena.odna.dao.model.entities.user.Role;
import com.cena.odna.dao.model.entities.user.User;
import com.cena.odna.dao.repository.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by Admin on 08.01.2017.
 */
public abstract class SessionFacadeImpl implements SessionFacade {

    @Autowired
    private UserManager userManager;

    private Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    public boolean isAuthenticated() {
        return SecurityContextHolder.getContext() != null &&
                getAuth().isAuthenticated();
    }

    @Override
    public String getUsername() {
        if (!isAuthenticated()) {
            return null;
        }
        return ((UserContext) getAuth().getPrincipal()).getUsername();
    }

    @Override
    public User getAuthenticatedUser() {
        if (!isAuthenticated()) {
            return null;
        }
        return userManager.findByUserName(getUsername());
    }

    @Override
    public Role getRole() {
        if (!isAuthenticated()) {
            return null;
        }
        GrantedAuthority authority = ((UserContext) getAuth().getPrincipal()).getAuthorities().get(0);
        return Role.parseAuthority(authority.getAuthority());
    }

    @Override
    public Boolean isAdmin() {
        return isAuthenticated() && Role.ADMIN.equals(getRole());
    }
}
