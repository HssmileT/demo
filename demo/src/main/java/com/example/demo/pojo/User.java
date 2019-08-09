package com.example.demo.pojo;

import com.github.pagehelper.Page;

import java.sql.Timestamp;
import java.util.Date;

/*User实体类*/
public class User {
    private int id;
    private String password;
    private String username;
    private String nikename;
    private String phone;
    private String email;
    private String lastLoginIp;
    private Timestamp lastLoginTime;
    private Timestamp createTime;
    Page<Media> medias;

    public User(){};

    public User(String username,String nikename,String password,String phone,String email,String lastLoginIp,Timestamp lastLoginTime,Timestamp createTime){
        this.username=username;
        this.nikename=nikename;
        this.password=password;
        this.email=email;
        this.phone=phone;
        this.lastLoginIp=lastLoginIp;
        this.createTime= createTime;
        this.lastLoginTime=lastLoginTime;
    }

    public Page<Media> getMedias() {
        return medias;
    }

    public void setMedias(Page<Media> medias) {
        this.medias = medias;
    }

    public String getNikename() {
        return nikename;
    }

    public void setNikename(String nikename) {
        this.nikename = nikename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
