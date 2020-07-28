package com.websocket.club.service;

import com.websocket.club.model.Image;
import com.websocket.club.respository.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageDao imageDao;

    public Image save(Image image){return imageDao.save(image);}
    public int delByUserId(Integer id){return imageDao.delByUserId(id);}
    public List<Image> getByUserId(Integer id){return imageDao.findByUserId(id);}
}
