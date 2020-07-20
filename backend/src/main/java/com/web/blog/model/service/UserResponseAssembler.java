package com.web.blog.model.service;

import com.web.blog.model.dto.User;
import com.web.blog.model.dto.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseAssembler {

    public UserResponse toDisplayableUser(User user) {
        if (user == null) {
            return null;
        }
        return new UserResponse().builder()
                .name(user.getName())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .password(user.getPassword())
                .build();
    }

}
