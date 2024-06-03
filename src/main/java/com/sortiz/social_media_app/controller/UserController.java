package com.sortiz.social_media_app.controller;

import com.sortiz.social_media_app.entity.User;
import com.sortiz.social_media_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URL;
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

        User user = new User();
        return this.userService.findOne(userId).equals(null) ? user : this.userService.findOne(userId);
    }

    // POST - Create user
    @PostMapping("/social-media-app/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {

        User createdUser = this.userService.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
