package com.websocket.club.service;


import com.websocket.club.model.User;
import com.websocket.club.respository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserByCredentials(String email, String password) throws Exception{return userDao.findUserByCredentials(email,password);}

    public User getUserById(Integer id){return userDao.findUserById(id);}

    public User saveUser(User u){return userDao.save(u);}

    public boolean deleteUser(Integer id){return userDao.delete(id);}
}
