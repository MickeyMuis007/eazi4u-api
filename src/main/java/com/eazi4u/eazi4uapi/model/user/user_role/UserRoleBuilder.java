package com.eazi4u.eazi4uapi.model.user.user_role;

import com.eazi4u.eazi4uapi.model.role.Role;
import com.eazi4u.eazi4uapi.model.user.User;

public class UserRoleBuilder {
    private static UserRoleBuilder userRoleBuilder;

    Long id;
    User user;
    Role role;

    public static UserRoleBuilder getInstance() {
        if (userRoleBuilder == null) {
            userRoleBuilder = new UserRoleBuilder();
        }
        return userRoleBuilder;
    }

    public UserRoleBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserRoleBuilder user(User user) {
        this.user = user;
        return this;
    }

    public UserRoleBuilder role(Role role) {
        this.role = role;
        return this;
    }

    public UserRoleBuilder copy(UserRole userRole) {
        id = userRole.id;
        user = userRole.user;
        role = userRole.role;
        return this;
    }

    public UserRole build() {
        return new UserRole(this);
    }
}
