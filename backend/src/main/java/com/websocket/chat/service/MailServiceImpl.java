package com.websocket.chat.service;

import com.websocket.chat.model.Mail;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {
    private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "chl30shl20@gmail.com";

    public boolean mailSend(Mail mail) {
        boolean isSent = true;
        try {
            MailHandler mailHandler = new MailHandler(mailSender);

            // 받는 사람
            mailHandler.setTo(mail.getAddress());
            // 보내는 사람
            mailHandler.setFrom(MailServiceImpl.FROM_ADDRESS);
            // 제목
            mailHandler.setSubject(mail.getTitle());
            // HTML Layout
            String htmlContent = "<p>" + mail.getMessage() +"<p> <img src='cid:sample-img'>";
            mailHandler.setText(htmlContent, true);
            // 첨부 파일
            //mailHandler.setAttach("newTest.txt", "static/originTest.txt");
            // 이미지 삽입
            //mailHandler.setInline("sample-img", "static/sample1.jpg");

            mailHandler.send();
        }
        catch(Exception e){
            e.printStackTrace();
            isSent = false;
        }

        return isSent;
    }

}
