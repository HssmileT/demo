package com.example.demo.dao;

import com.example.demo.pojo.Media;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;


public interface MediaDao {
    public Page<Media> selectAllImages(@Param("nikename") String nikename, @Param("title") String title);
}
