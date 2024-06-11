package com.sortiz.social_media_app.controller;

import com.sortiz.social_media_app.entity.User;
import com.sortiz.social_media_app.service.UserService;
import com.sortiz.social_media_app.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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

        User user = this.userService.findOne(userId);

        if (Objects.isNull(user)) {

            throw new UserNotFoundException("The user with id: " + userId + " not found!");
        }
        return user;
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
