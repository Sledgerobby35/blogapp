package com.codeup.blogapp.data;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.Date;

public class User {

    private long id;
    private String username;
    private String email;
    private String password;
//    private LocalDateTime createdAt;
    private Role role = Role.USER;

    public enum Role {USER, ADMIN}

    public User() {
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
//        this.createdAt = createdAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public Date getCreatedAt() {
//        return createdAt;
//    }

//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}