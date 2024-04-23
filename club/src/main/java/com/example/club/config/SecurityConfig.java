package com.example.club.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices.RememberMeTokenAlgorithm;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.club.handler.ClubLoginSucessHandler;

@EnableMethodSecurity // @PreAuthorize 활성화
@EnableWebSecurity
@Configuration
public class SecurityConfig {

    // Bean : 객체 생성해서 해줘
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, RememberMeServices remembermMeServices)
            throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                // static 디자인 사용 위해 "/static/**" 열어야함
                // 1. 접근 제한 경로를 일일이 지정하는 방법
                // .requestMatchers("/", "/auth", "/static/**", "/img/*").permitAll()
                // .requestMatchers("/club/member").hasAnyRole("USER", "MANAGER", "ADMIN")
                // .requestMatchers("/club/manager").hasAnyRole("MANAGER")
                // .requestMatchers("/club/admin").hasAnyRole("ADMIN"))

                // 2. 간략하게 하기 - 컨트롤러 경로에 권한 어노테이션 추가
                .requestMatchers("/static/**", "/img/*").permitAll()
                .anyRequest().permitAll())

                .formLogin(login -> login
                        .loginPage("/club/member/login").permitAll()
                        .successHandler(clubLoginSucessHandler()))
                .rememberMe(remember -> remember.rememberMeServices(remembermMeServices))
                // .oauth2Login(Customizer.withDefaults())
                .oauth2Login(login -> login.successHandler(clubLoginSucessHandler()))
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/club/member/logout"))
                        .logoutSuccessUrl("/"));
        return http.build();
    }

    // 자동 로그인 처리 - 쿠키 이용
    @Bean
    RememberMeServices rememberMeServices(UserDetailsService userDetailsService) {
        // 비밀번호 알고리즘 사용 - 암호화 : RememberMeTokenAlgorithm.SHA256;
        RememberMeTokenAlgorithm encodingAlgorithm = RememberMeTokenAlgorithm.SHA256;
        // myKey 라는 이름으로 암호화한 비밀번호 저장
        TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("myKey", userDetailsService,
                encodingAlgorithm);
        rememberMeServices.setTokenValiditySeconds(60 * 60 * 24 * 7); // 7일간 : 쿠키 만료 시간 설정 (무한정 x)
        return rememberMeServices;
    }

    // 암호화 (encode), 비밀번호 입력값 검증 (matches) : PasswordEncoder
    // 단방향 암호화 : 암호화만 가능하고 복호화는 불가능 (암호화된 비밀번호에서 원래 비밀번호 유추 x - 잊어버리면 새 비밀번호 생성해야함)
    @Bean // 객체 생성
    PasswordEncoder PasswordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    ClubLoginSucessHandler clubLoginSucessHandler() {
        return new ClubLoginSucessHandler();
    }
}
