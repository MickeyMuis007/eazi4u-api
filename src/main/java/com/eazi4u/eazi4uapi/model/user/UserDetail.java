package com.eazi4u.eazi4uapi.model.user;

import com.eazi4u.eazi4uapi.model.user.User;
import com.eazi4u.eazi4uapi.model.user.user_role.UserRole;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name="userDetail", types = {User.class})
public interface UserDetail {
    String getName();
    String getUsername();
    String getPassword();
    List<UserRole> getUserRoles();
}
