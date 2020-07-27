package com.websocket.chat.service;


import com.websocket.chat.model.Mail;

public interface MailService {

    boolean mailSend(Mail mail);

}
