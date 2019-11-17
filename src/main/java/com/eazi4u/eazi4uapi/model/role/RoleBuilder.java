package com.eazi4u.eazi4uapi.model.role;

public class RoleBuilder {
    private static RoleBuilder roleBuilder;

    Long id;
    String name;
    String description;

    public static RoleBuilder getInstance() {
        if (roleBuilder == null) {
            roleBuilder = new RoleBuilder();
        }
        return roleBuilder;
    }

    public RoleBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public RoleBuilder name(String name) {
        this.name = name;
        return this;
    }

    public RoleBuilder description(String description) {
        this.description = description;
        return this;
    }

    public RoleBuilder copy(Role role) {
        this.id = role.id;
        this.name = role.name;
        this.description = role.description;
        return this;
    }

    public Role build() {
        return new Role(this);
    }

}
