package com.websocket.chat.controller;

import java.util.Optional;

import javax.validation.Valid;

import com.websocket.chat.model.*;
import com.websocket.chat.service.MailService;
import com.websocket.chat.service.UserResponseAssembler;
import com.websocket.chat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    @Autowired
    UserService userService;
    @Autowired
    MailService mailService;
    private final UserResponseAssembler userResponseAssembler;

    @GetMapping("/login")
    @ApiOperation(value = "로그인")
    public ResponseEntity<UserResponse> login(
            @RequestParam final String email,
            @RequestParam final String password
    ) {
        User user = userService.login(email, password);

        if(user == null) {
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }

        UserResponse userResponse = userResponseAssembler.toDisplayableUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping("/signup")
    @ApiOperation(value = "가입하기")
    public Object signup(@Valid @RequestBody SignupRequest request) {
        User user = new User().builder()
                .email(request.getEmail())
                .name(request.getName())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        boolean isSaved;

        if(userService.signUp(user) != null) {
            isSaved = true;
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        ResponseEntity response;

        if(isSaved) {
            final BasicResponse result = new BasicResponse();
            result.status = true;
            result.data = "success";

            // 인증 이메일 발송
            boolean isSent = mailService.mailSend(
                    Mail.builder()
                        .address(request.getEmail())
                        .message("회원가입 인증 메일입니다.")
                        .title("회원가입 인증 메일입니다.")
                        .build());

            result.object = isSent ?
                    "회원가입 인증 메일이 발송되었습니다. 이메일을 확인해 주세요"
                    : "메일발송에 실패하였습니다";

            response = new ResponseEntity<>(result, HttpStatus.OK);

        } else {
            response = new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        }
        return response;
    }

    @PostMapping
    @ApiOperation(value = "사용자 정보 조회")
    public ResponseEntity<UserResponse> getMe(@RequestBody String email) {

        User user = userService.getUser(email);

        if(user == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

        UserResponse userResponse = userResponseAssembler.toDisplayableUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "사용자 정보 수정")
    public Object updateMe(@RequestBody UserUpdateRequest request) {

        User user = new User().builder()
                .email(request.getEmail())
                .name(request.getName())
                .nickname(request.getNickname())
                .password(request.getPassword())
                .build();

        if (userService.updateUser(user) != null) {
            final BasicResponse result = new BasicResponse();
            result.status = true;
            result.data = "success";
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/delete")
    @ApiOperation(value = "사용자 정보 삭제")
    public Object deleteMe(@RequestBody UserDeleteRequest request) {

        // 해당 사용자가 있는지 확인 & 패스워드가 맞는지 확인 -> 둘 다 만족할 시 탈퇴 진행
        boolean isDeleted = userService.deleteUser(request.getEmail(), request.getPassword());

        if (isDeleted) {
            final BasicResponse result = new BasicResponse();
            result.status = true;
            result.data = "success";
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
    }

}