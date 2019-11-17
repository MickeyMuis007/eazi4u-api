package com.eazi4u.eazi4uapi.repository.user;

import com.eazi4u.eazi4uapi.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
