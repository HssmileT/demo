package com.example.demo.util;

import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Logger;

public class CookieUtil {

    public static final int CookieMaxAge=24*3600;

    public static String getToken(String username){
        String token = (System.currentTimeMillis() + new Random().nextInt(999999999)) + "";
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] =  md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            System.out.println(encoder.encode(md5));
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Cookie getCookie(HttpServletRequest request, String name){
        Cookie[] cookies=request.getCookies();
        if(cookies==null||cookies.length==0){
            return null;
        }
        Cookie cookie=null;
        for(Cookie c:cookies){
            if(name.equals(c.getName())){
                cookie=c;
                break;
            }
        }
        return cookie;
    }

    public static void setCookie(HttpServletResponse response,String name,String value,int age){
        if(name==null){
            return;
        }
        if(value==null){
            value="";
        }
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/");
        if(age>0){
            cookie.setMaxAge(age);
        }
        else{
            cookie.setMaxAge(CookieMaxAge);
            response.addCookie(cookie);
        }
        try{
            response.flushBuffer();
        }catch (IOException e){
            LoggerUtil.log.debug(e.getMessage());
        }
    }

}
