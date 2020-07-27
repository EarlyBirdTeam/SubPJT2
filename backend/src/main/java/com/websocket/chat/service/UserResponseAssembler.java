package com.websocket.chat.service;

import com.websocket.chat.model.User;
import com.websocket.chat.model.UserResponse;
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
