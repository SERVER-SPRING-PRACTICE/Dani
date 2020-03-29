package com.example.boardpractice.model;

import lombok.Data;

@Data
// 클라이언트 -> 서버
public class SignupReq {
    private String userName;
    private String userId;
    private String userPw;
}
