package com.sortiz.social_media_app.dao;

import com.sortiz.social_media_app.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoImp implements UserDao{

//    persist with jpa
//    static list
    public static int userCount = 0;
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(++userCount, "Peter Parker", LocalDate.now().minusYears(23)));
        userList.add(new User(++userCount, "Peter Quill", LocalDate.now().minusYears(29)));
        userList.add(new User(++userCount, "Scott Summers", LocalDate.now().minusYears(28)));
    }
//    save
//    find all
    public List<User> findAll() {

        return userList;
    }
//    find

    @Override
    public User findOne(Integer userId) {

        Predicate<? super User> predicate = user -> user.getId().equals(userId);
        return userList.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public User save(User user) {

        user.setId(++userCount);
        userList.add(user);
        return user;
    }

    @Override
    public void delete(Integer userId) {

        Predicate<? super User> predicate = u -> u.getId().equals(userId);
        userList.removeIf(predicate);
    }
}
