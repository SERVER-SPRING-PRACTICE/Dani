package com.example.boardpractice.controller;

import com.example.boardpractice.dto.User;
import com.example.boardpractice.model.SignupReq;
import com.example.boardpractice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.boardpractice.model.DefaultRes.FAIL_DEFAULT_RES;

@Slf4j
@RestController
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService){ this.userService = userService;}

    @PostMapping("signup")
    public ResponseEntity signup(@RequestBody final SignupReq signupReq){
        try{
            return new ResponseEntity<>(userService.save(signupReq), HttpStatus.OK);
        } catch (Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

// pull request test