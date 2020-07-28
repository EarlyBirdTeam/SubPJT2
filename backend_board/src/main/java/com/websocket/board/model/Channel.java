package com.websocket.board.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class Channel implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    private String channelId;
    private String name;
    private long userCount; // 채팅방 인원수

    public static Channel create(String name) {
        Channel channel = new Channel();
        channel.channelId = UUID.randomUUID().toString();
        channel.name = name;
        return channel;
    }
}
