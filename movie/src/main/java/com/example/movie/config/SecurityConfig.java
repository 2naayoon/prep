package com.example.movie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableMethodSecurity
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/assets/**", "/css/**", "/js/**", "/auth").permitAll()
                .requestMatchers("/movie/list", "/movie/read").permitAll()
                // 사진 업로드
                .requestMatchers("/upload/display").permitAll()
                .requestMatchers("/reviews/**").permitAll()
                .requestMatchers("/member/register").permitAll()
                .anyRequest().authenticated());
        // login 페이지는 /member/login 경로요청 해야함
        // login 성공 후 이동경로는 시작했던 곳으로 가는게 기본
        http.formLogin(login -> login.loginPage("/member/login").permitAll()
                .defaultSuccessUrl("/movie/list", true));
        http.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .logoutSuccessUrl("/"));

        // csrf 를 막으면 get 을 제외한 모든 방식은 csrf 토큰이 필요함
        // → thymeleaf 에서는 form:action 을 삽입하면 자동으로 만들어 준다
        // → 403 발생 시 csrf 토큰이 포함되었는지 1차 확인
        // → 입력값 2차 확인
        // csrf 를 열면 필터 비활성화 (잠시 시큐리티 비활성화)
        // http.csrf(csrf -> csrf.disable());

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
