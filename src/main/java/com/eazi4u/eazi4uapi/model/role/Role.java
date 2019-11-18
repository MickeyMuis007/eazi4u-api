package com.eazi4u.eazi4uapi.model.role;

import com.eazi4u.eazi4uapi.model.user.user_role.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;

    @OneToMany(cascade = CascadeType.ALL)
    List<UserRole> userRoles = new ArrayList<>();

    private Role() { }

    Role(RoleBuilder builder) {
        id = builder.id;
        name = builder.name;
        description = builder.description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
