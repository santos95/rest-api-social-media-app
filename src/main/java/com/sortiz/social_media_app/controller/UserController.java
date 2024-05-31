package com.sortiz.social_media_app.controller;

import com.sortiz.social_media_app.entity.User;
import com.sortiz.social_media_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/social-media-app")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET - ALL USERS
    @GetMapping("/social-media-app/users")
    public List<User> retrieveAllUsers() {

        return this.userService.findAll();
    }

    // GET - user
    @GetMapping("/social-media-app/users/{userId}")
    public User retrieveUser(@PathVariable int userId) {

        return this.userService.findOne(userId);
    }
}
