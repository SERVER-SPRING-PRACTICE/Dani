package com.example.boardpractice.mapper;

import com.example.boardpractice.dto.User;
import com.example.boardpractice.model.SignupReq;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO User(userName, userId, userPw) VALUES(#{signupReq.userName},#{signupReq.userId},#{signupReq.userPw})")
    // @Options(useGeneratedKeys = true, keyColumn = "user.userIdx")
    int signup(@Param("signupReq") final SignupReq signupReq);

}
