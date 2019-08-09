package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {

    int addUser(User user);

    User selectUserById(@Param("username") String username, @Param("password") String password);

    List<User> getAllUser();
}
