package com.eazi4u.eazi4uapi.controller.user;

import com.eazi4u.eazi4uapi.model.user.User;
import com.eazi4u.eazi4uapi.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/user")
public class UserController {
    @Autowired
    IUserRepository userRepository;

    @GetMapping
    public List<User> list() {
        return userRepository.findAll();
    }

    @PostMapping
    public User create(@RequestBody final User user) {
        return userRepository.saveAndFlush(user);
    }
}
