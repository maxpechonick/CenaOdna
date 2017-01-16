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

    private static final String PREFIX = "ROLE_";

    public String authority() {
        return PREFIX + this.name();
    }

    public static Role parseAuthority(String authority) {
        if (authority == null ||
                authority.length() <= PREFIX.length() ||
                !authority.contains(PREFIX)) {
            return null;
        }
        authority = authority.substring(PREFIX.length());
        for (Role role : values()) {
            if (role.name().equals(authority)) {
                return role;
            }
        }
        return null;
    }

}
