package com.websocket.club.respository;

import com.websocket.club.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
   /*User getUserByEmail(String email);*/
    User save(User user);
    User findUserById(Integer id);
    User findUserByCredentials(String email, String password) throws Exception;
    boolean delete(Integer id);
}
