package com.cena.odna.core.mvc.service.core;

import com.cena.odna.dao.model.entities.user.Role;
import com.cena.odna.dao.model.entities.user.User;

import java.io.Serializable;

/**
 * Created by Admin on 08.01.2017.
 */
public interface SessionFacade extends Serializable {

    boolean isAuthenticated();
    String getUsername();
    User getAuthenticatedUser();
    Role getRole();

    Boolean isAdmin();
}
