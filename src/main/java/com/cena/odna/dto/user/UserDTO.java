package com.cena.odna.dto.user;

import com.cena.odna.dao.model.entities.user.Role;
import com.cena.odna.dao.model.entities.user.Sex;
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
    private String firstName;
    private String lastName;
    private Sex sex;
    private String email;
    private String about;
    private String image;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
