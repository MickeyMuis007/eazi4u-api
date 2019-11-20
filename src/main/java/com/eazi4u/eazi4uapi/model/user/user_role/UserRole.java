package com.eazi4u.eazi4uapi.model.user.user_role;

import com.eazi4u.eazi4uapi.model.role.Role;
import com.eazi4u.eazi4uapi.model.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne
    @JoinColumn(name="user_id", insertable = true, updatable = true, nullable=false)
    User user;

    @ManyToOne
    @JoinColumn(name="role_id", insertable = true, updatable = true, nullable=false)
    Role role;

    public UserRole() {}

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

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
