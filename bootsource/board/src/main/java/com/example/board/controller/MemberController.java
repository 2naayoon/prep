package com.example.board.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.board.dto.MemberDto;
import com.example.board.dto.PageRequestDto;
import com.example.board.service.MemberService;

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

    private final MemberService service;

    @PreAuthorize("permitAll()")
    @GetMapping("/login")
    public void getLogin(@ModelAttribute("requestDto") PageRequestDto requestDto) {
        log.info("로그인 폼 요청");
    }

    // @Valid - get 방식일때도 따라 들어가야함
    @PreAuthorize("permitAll()")
    @GetMapping("/register")
    public void getRegister(MemberDto memberDto, @ModelAttribute("requestDto") PageRequestDto requestDto) {
        log.info("회원가입 페이지 요청");
    }

    @PostMapping("/register")
    public String postRegister(@Valid MemberDto dto, BindingResult result, RedirectAttributes rttr,
            @ModelAttribute("requestDto") PageRequestDto requestDto) {
        log.info("회원가입 요청 {}", dto);

        if (result.hasErrors())
            return "/member/register";

        try {
            service.register(dto);
        } catch (Exception e) {
            e.printStackTrace();
            // addAttribute : 주소줄에 딸려보냄
            // rttr.addAttribute("dupEmail", e.getMessage());
            // addFlashAttribute : 잠깐 세션형태로 보냄
            rttr.addFlashAttribute("dupEmail", e.getMessage());

            // sendredirect 방식
            return "redirect:/member/register";
            // forward 방식
            // return "/member/register";
        }

        return "redirect:/member/login";
    }

}
