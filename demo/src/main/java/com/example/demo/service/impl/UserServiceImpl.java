package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.CookieUtil;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Resource
    RedisUtil redisUtil;

    @Override
    public boolean addUser(User user) {
        if(userDao.addUser(user)>0){
            return true;
        }
        return false;
    }

    @Override
    public String login(String username, String password) {
        String token="";
        User user =userDao.selectUserById(username, password);
        if(user != null){
            try {
                token= CookieUtil.getToken(user.getUsername());
                redisUtil.set(token,user,10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return token;
    }

    @Override
    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        return userList;
    }

    public User getUserInfo(String token){
        if(redisUtil.hasKey(token)) {
            return (User) redisUtil.get(token);
        }
        return null;
    }
}
