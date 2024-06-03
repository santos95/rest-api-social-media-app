package com.sortiz.social_media_app.dao;

import com.sortiz.social_media_app.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findOne(Integer userId);
    User save(User user);
}
