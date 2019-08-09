package com.example.demo.controller;


import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.util.CookieUtil;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Resource
    RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(HttpServletRequest request,Model model) {
        Cookie cookie = CookieUtil.getCookie(request,"token");
        if (cookie!=null){
            String token=cookie.getValue();
            User user= userService.getUserInfo(token);
            if (user!=null){
                model.addAttribute("username",user.getUsername());
            }
        }
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        Cookie cookie = CookieUtil.getCookie(request,"token");
        if (cookie!=null){
            String token=cookie.getValue();
            User user= userService.getUserInfo(token);
            if (user!=null){
                model.addAttribute("username",user.getUsername());
                return "index";
            }
        }
        return "login";
    }

}
