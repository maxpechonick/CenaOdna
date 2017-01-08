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
    private Role role;
    private String password;

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
