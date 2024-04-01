package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/login")
    public void login() {
        log.info("로그인 페이지 요청");
    }

    // @PostMapping("/login")
    // public void loginPost(String email, String name) {
    // log.info("로그인 정보 가져오기");
    // log.info("email {}", email);
    // log.info("name {}", name);
    // }

    // Model : spring framework
    @PostMapping("/login")
    public String loginPost(@ModelAttribute("mDto") MemberDto mDto, @ModelAttribute("page") int page, Model model) {
        log.info("로그인 정보 가져오기");
        log.info("email {}", mDto.getEmail());
        log.info("name {}", mDto.getName());
        log.info("page {}", page);

        // model.addAttribute("page", page); = @ModelAttribute("page")

        // post 받고 내용 실행 후 info 로 리턴
        return "/member/info";
    }

    // 데이터 보내기 - 다음 페이지까지
    // request.setAttribute("이름", 값) == Model
    // 파라메터로 값 받아올 때는 @ModelAttribute("page") / 직접 값을 설정할 때는
    // model.addAttribute("page", page);
}
