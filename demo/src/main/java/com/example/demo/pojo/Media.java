package com.example.demo.pojo;

import java.sql.Time;
import java.sql.Timestamp;

public class Media {
     int id;
    int uid;
    int tid;
     String url,title;
     Timestamp createTime;
     int isVideo;

     public Media(int uid, String url, String title, Timestamp createTime,int isVideo){
         this.uid=uid;
         this.url=url;
         this.title=title;
         this.createTime=createTime;
         this.isVideo=isVideo;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(int isVideo) {
        this.isVideo = isVideo;
    }
}
