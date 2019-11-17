package com.eazi4u.eazi4uapi.model.user.user_role;

import com.eazi4u.eazi4uapi.model.user.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;

    @ManyToOne
    User user;

    public Long getId() {
        return id;
    }

}
