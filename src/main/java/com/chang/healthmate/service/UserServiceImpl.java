package com.chang.healthmate.service;

import com.chang.healthmate.dto.RequestUser;
import com.chang.healthmate.dto.Response;
import com.chang.healthmate.repository.user.User;
import com.chang.healthmate.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final Response response;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    @Override
    public ResponseEntity<Response.Body> signUp(RequestUser.SignUp signUpDto) {
        if (!signUpDto.getPassword().equals(signUpDto.getConfirmPassword())) {
            return response.fail("재확인 비밀번호를 다시 확인해주십시오.", HttpStatus.UNAUTHORIZED);
        }
        if (userRepository.existsByUserId(signUpDto.getUserId())) {
            return response.fail("이미 회원가입된 이메일입니다.", HttpStatus.BAD_REQUEST);
        }
        User user = signUpDto.toUser(passwordEncoder);
        userRepository.save(user);
        return response.success("회원가입에 성공했습니다.");
    }
}
