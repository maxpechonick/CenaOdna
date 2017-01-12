package com.cena.odna.dao.model.entities.user;

/**
 * Created by Admin on 12.12.2016.
 */
public enum Role {

    SUPERADMIN,
    ADMIN,
    CEO,
    USER,
    ANONYMOUS;

    public String authority() {
        return "ROLE_" + this.name();
    }

}
