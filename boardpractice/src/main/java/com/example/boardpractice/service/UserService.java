package com.example.boardpractice.service;

import com.example.boardpractice.dto.User;
import com.example.boardpractice.mapper.UserMapper;
import com.example.boardpractice.model.DefaultRes;
import com.example.boardpractice.model.SignupReq;
import com.example.boardpractice.utils.ResponseMessage;
import com.example.boardpractice.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(final UserMapper userMapper){ this.userMapper = userMapper;}

    public DefaultRes save(final SignupReq signupReq){
        try{
            userMapper.signup(signupReq);
            return DefaultRes.res(StatusCode.CREATED,ResponseMessage.SIGN_UP_INSERT_SUCCESS);
        } catch(Exception e){
            log.error(e.getMessage());
            return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
        }
    }
}
