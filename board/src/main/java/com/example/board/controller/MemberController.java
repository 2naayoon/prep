package com.example.board.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.dto.MemberDto;
import com.example.board.dto.PageRequestDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
@Controller
public class MemberController {

    @PreAuthorize("permitAll()")
    @GetMapping("/login")
    public void getLogin(@ModelAttribute("requestDto") PageRequestDto requestDto) {
        log.info("로그인 폼 요청");

    }

    @PreAuthorize("permitAll()")
    @GetMapping("/register")
    public void getRegister(@ModelAttribute("requestDto") PageRequestDto requestDto) {
        log.info("회원가입 페이지 요청");
    }

    @PostMapping("/register")
    public String postRegister(@Valid MemberDto dto) {
        log.info("회원가입 요청 {}", dto);
        return "redirect:/member/login";
    }

}
