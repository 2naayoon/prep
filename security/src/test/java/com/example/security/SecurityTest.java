package com.example.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class SecurityTest {
    // SecurityConfig 의 passwordEncoder() 메소드 호출 - 실행되면서 주입됨
    @Autowired
    private PasswordEncoder passwordEncoder; // 비밀번호 암호화(encode), 원 비밀번호와 암호화된 비밀번호의 일치 여부(matches)

    @Test
    public void testEncoder() {
        // 원 비밀번호
        String password = "1111";

        // 원 비밀번호 암호화
        String encodePassword = passwordEncoder.encode(password);

        // password : 1111
        // encode password :
        // {bcrypt}$2a$10$gfbGQr1Sr4mdDFh2xIt7AOmFBXquwWED5fAM4uJuuQFYE941jaWHy
        // {bcrypt} : 암호화 알고리즘 (기본)
        System.out.println("password : " + password + ", encode password " + encodePassword);

        // matches(원비밀번호, 암호화된비밀번호) = true
        // (1111, {bcrypt}$2a$10$gfbGQr1Sr4mdDFh2xIt7AOmFBXquwWED5fAM4uJuuQFYE941jaWHy)
        System.out.println(passwordEncoder.matches(password, encodePassword));
    }
}
