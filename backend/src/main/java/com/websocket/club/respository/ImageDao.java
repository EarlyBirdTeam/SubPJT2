package com.websocket.club.respository;
import com.websocket.chat.model.User;
import com.websocket.club.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageDao extends JpaRepository<Image, Integer> {
    Image save(Image image);
    int delByUserId(Integer id);
    List<Image> findByUserId(Integer id);
}
