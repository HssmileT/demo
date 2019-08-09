package com.example.demo.service.impl;

import com.example.demo.dao.MediaDao;
import com.example.demo.pojo.Media;
import com.example.demo.service.MediaService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service(value = "mediaService")
public class MediaServiceImpl implements MediaService {

    @Resource
    MediaDao mediaDao;

    @Override
    public Page<Media> getAllImages(String nikename, String title) {
        return mediaDao.selectAllImages(nikename,title);
    }
}
