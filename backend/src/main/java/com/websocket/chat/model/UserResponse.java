package com.websocket.chat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;
    private String email;
    private String password;
    private String nickname;
}
