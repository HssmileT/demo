package com.example.demo.service;

import com.example.demo.pojo.Media;
import com.github.pagehelper.Page;


public interface MediaService {
    public Page<Media> getAllImages(String nikename, String title);
}
