package com.eazi4u.eazi4uapi.model.user;

import com.eazi4u.eazi4uapi.model.user.user_role.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String username;
    String password;

    @OneToMany(cascade = CascadeType.ALL)
    List<UserRole> userRoles = new ArrayList<UserRole>();

    private User() {
    }

    public User(UserBuilder builder) {
        id = builder.id;
        name = builder.name;
        username = builder.username;
        password = builder.password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
