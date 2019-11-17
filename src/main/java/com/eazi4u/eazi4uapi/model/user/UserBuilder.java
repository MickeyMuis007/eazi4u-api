package com.eazi4u.eazi4uapi.model.user;

public class UserBuilder {
    private static UserBuilder userBuilder;

    Long id;
    String name;
    String username;
    String password;

    public static UserBuilder getInstance() {
        if (userBuilder == null) {
            userBuilder = new UserBuilder();
        }
        return userBuilder;
    }

    public UserBuilder id(Long id) {
        this.id = id;
        return this;
    }

    public UserBuilder name(String name) {
        this.name = name;
        return this;
    }

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder copy(User user) {
        this.id = user.id;
        this.name = user.name;
        this.username = user.username;
        this.password = user.password;
        return this;
    }

    public User build() {
        return new User(this);
    }
}
