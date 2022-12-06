package com.chang.healthmate.dto;

import com.chang.healthmate.repository.user.User;
import com.chang.healthmate.repository.user.UserRole;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

public class RequestUser {
    @Getter
    @Setter
    public static class SignUp {

        @Pattern(regexp = "^([a-z0-9]*)$", message = "영문이랑 숫자로 5글자 이상~20글자이하(특수문자 x,@ x,)")
        private String userId;

        @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 혼합하여 사용하세요.")
        private String password;

        private String confirmPassword;

        @Pattern(regexp = "(?=.*[0-9a-zA-Zㄱ-ㅎ가-힣]).{2,16}", message = "유저네임은 2~16자의 영문 대 소문자, 숫자와 한글만 사용 가능합니다.")
        private String userName;

        public User toUser(PasswordEncoder passwordEncoder) {
            return User.builder()
                    .userId(userId)
                    .password(passwordEncoder.encode(password))
                    .userName(userName)
                    .userRole(UserRole.USER)
                    .build();
        }
    }
}
