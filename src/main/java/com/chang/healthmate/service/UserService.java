package com.chang.healthmate.service;


import com.chang.healthmate.dto.RequestUser;
import com.chang.healthmate.dto.Response;
import org.springframework.http.ResponseEntity;


public interface UserService {
    // 로그인

    // 로그아웃

    // 회원가입
    public ResponseEntity<Response.Body> signUp(RequestUser.SignUp userDto);

    //



}
