package com.eazi4u.eazi4uapi.model.user;

import com.eazi4u.eazi4uapi.model.user.user_role.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

    @Column(unique = true)
    String username;
    String password;
    String email;
    boolean enabled;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="user_Id")
    List<UserRole> userRoles = new ArrayList<UserRole>();

    private User() {
    }

    public User(UserBuilder builder) {
        id = builder.id;
        name = builder.name;
        username = builder.username;
        password = builder.password;
        email = builder.email;
        enabled = builder.enabled;
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

    public String getEmail() {
        return email;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }
}
