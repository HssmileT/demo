package com.example.demo.controller;

import com.example.demo.pojo.Media;
import com.example.demo.service.MediaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @RequestMapping("/getAllImages")
    public PageInfo<Media> getAllImages(@RequestParam(name = "pageNo", required = false,defaultValue = "1")int pageNo,
                                        @RequestParam(name = "pageSize", required = false,defaultValue = "10")int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Media> images=new PageInfo<>(mediaService.getAllImages());
        return images;
    }
}
