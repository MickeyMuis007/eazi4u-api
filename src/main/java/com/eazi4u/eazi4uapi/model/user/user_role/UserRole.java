package com.eazi4u.eazi4uapi.model.user.user_role;

import com.eazi4u.eazi4uapi.model.role.Role;
import com.eazi4u.eazi4uapi.model.user.User;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    User user;

    @ManyToOne
    Role role;

    private UserRole() {}

    UserRole(UserRoleBuilder builder) {
        id = builder.id;
        user = builder.user;
        role = builder.role;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Role getRole() {
        return role;
    }
}
