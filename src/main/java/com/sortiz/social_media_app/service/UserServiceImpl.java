package com.sortiz.social_media_app.service;

import com.sortiz.social_media_app.dao.UserDaoImp;
import com.sortiz.social_media_app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDaoImp userDaoImp;

    @Autowired
    public UserServiceImpl(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }

    public List<User> findAll() {

        return this.userDaoImp.findAll();
    }

    @Override
    public User findOne(Integer userId) {

        return this.userDaoImp.findOne(userId);
    }

    @Override
    public User createUser(User user) {

        return this.userDaoImp.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {

        this.userDaoImp.delete(userId);
    }
}
