package com.example.demo.service;

import com.example.demo.pojo.User;

import javax.servlet.http.Cookie;
import java.util.List;

public interface UserService {

    boolean addUser(User user);

    String login(String username,String password);

    List<User> getAllUser();

    public User getUserInfo(String token);
}
