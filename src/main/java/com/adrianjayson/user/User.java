package com.adrianjayson.user;

import com.adrianjayson.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;

@Entity
public class User extends BaseEntity {
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private String firstName;
    private String lastName;
    private String username;

    @JsonIgnore
    private String password;
    @JsonIgnore
    private String[] roles;

    protected User() {
        super();
    }

    public User(String username, String firstName, String lastName, String passwords, String[] roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.setPassword(passwords);
        this.roles = roles;
    }

    public void setPassword(String passwords) {
        this.password = PASSWORD_ENCODER.encode(passwords);
    }

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

    public String getPassword() {
        return password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
