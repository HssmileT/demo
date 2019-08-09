package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.CookieUtil;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

@Controller
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Resource
    RedisUtil redisUtil;

    @ResponseBody
    @PostMapping(value = "/login")
    public String login(@RequestParam(name = "username", required = false) String username,
                        @RequestParam(name = "password", required = false) String password, HttpServletResponse response,
                        HttpServletRequest request, Model model) {
        String token=userService.login(username,password);
        if(!token.equals("")){
            CookieUtil.setCookie(response,"token",token,0);
            User user=(User)redisUtil.get(token);
            model.addAttribute("nikename",user.getNikename());
            return "Success";
        }
        return "login";
    }

    @ResponseBody
    @PostMapping(value = "/signUp")
    public String signUp(@RequestParam(name = "username", required = false) String username,
                        @RequestParam(name = "password", required = false) String password,
                         @RequestParam(name = "nikename", required = false) String nikename,
                         @RequestParam(name = "email", required = false) String email,
                         @RequestParam(name = "phone", required = false) String phone, HttpServletResponse response,
                        HttpServletRequest request,Model model) {
        Timestamp now= new Timestamp(System.currentTimeMillis());
        User user = new User(username,nikename,password,phone,email,"",now,now);
        if(userService.addUser(user)){
                return login(username,password,response,request,model);
        }
        return "";
    }
}
