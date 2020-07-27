package com.websocket.chat.service;

import com.websocket.chat.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByEmailAndPassword(String email, String password);

    User login(String email, String password);

    User signUp(User user);

    User getUser(String email);

    Optional<User> getUserByNickname(String nickname);

    User updateUser(User user);

    boolean deleteUser(String email, String password);

}
