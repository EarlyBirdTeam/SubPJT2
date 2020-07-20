package com.web.blog.model.service;

import com.web.blog.dao.user.UserDao;
import com.web.blog.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public Optional<User> findUserByEmailAndPassword(String email, String password) {
        return userDao.findUserByEmailAndPassword(email, password);
    }

    @Override
    public User login(String email, String password) {
        Optional<User> user = userDao.findUserByEmailAndPassword(email, password);

        if(!user.isPresent()) return null;

        User u = new User().builder()
                .email(user.orElse(null).getEmail())
                .name(user.orElse(null).getName())
                .nickname(user.orElse(null).getNickname())
                .password(user.orElse(null).getPassword())
                .build();

        return u;
    }

    @Override
    public User signUp(User user) {
        Optional<User> userEmailCheck = userDao.getUserByEmail(user.getEmail());
        Optional<User> userNickCheck = userDao.getUserByNickname(user.getNickname());

        if(!userEmailCheck.isPresent() && !userNickCheck.isPresent()) {
            return userDao.save(user);
        }
        return null;
    }

    @Override
    public User getUser(String email) {
        Optional<User> user = userDao.getUserByEmail(email);

        if(!user.isPresent()) return null;

        User u = new User().builder()
                .email(user.orElse(null).getEmail())
                .name(user.orElse(null).getName())
                .nickname(user.orElse(null).getNickname())
                .password(user.orElse(null).getPassword())
                .build();

        return u;
    }

    @Override
    public Optional<User> getUserByNickname(String nickname) {
        return userDao.getUserByNickname(nickname);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> userEmailCheck = userDao.getUserByEmail(user.getEmail());
        Optional<User> userNickCheck = userDao.getUserByNickname(user.getNickname());

        if ((userEmailCheck.isPresent() && userEmailCheck.orElse(null).getNickname().equals(user.getNickname()))
            || (userEmailCheck.isPresent() && !userNickCheck.isPresent())) {
            user.setUid(userEmailCheck.orElse(null).getUid());
            return userDao.save(user);
        }
        return null;
    }

    @Override
    @Transactional
    public boolean deleteUser(String email, String password) {
        Optional<User> user = userDao.findUserByEmailAndPassword(email, password);

        if(!user.isPresent()) return false;

        userDao.deleteByEmail(email);

        return true;
    }


}
