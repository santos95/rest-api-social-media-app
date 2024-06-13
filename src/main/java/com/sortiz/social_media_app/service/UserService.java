package com.sortiz.social_media_app.service;

import com.sortiz.social_media_app.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findOne(Integer userId);

    User createUser(User user);

    void deleteUser(Integer userId);
}
