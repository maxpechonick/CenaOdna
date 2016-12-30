package com.cena.odna.dto.user;

import com.cena.odna.dao.model.entities.user.Role;
import com.cena.odna.dto.core.AbstractDTO;

import java.util.List;

/**
 * Created by Admin on 22.12.2016.
 */
public class UserDTO extends AbstractDTO {

    private String username;
    private Boolean enabled;
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
