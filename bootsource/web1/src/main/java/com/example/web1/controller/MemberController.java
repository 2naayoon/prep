package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.web1.dto.LoginDto;
import com.example.web1.dto.MemberDto;

import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
@RequestMapping("/member")
public class MemberController {
    @GetMapping("/login")
    public void login(LoginDto loginDto) {
        log.info("로그인 페이지 요청");
    }

    // @PostMapping("/login")
    // public void loginPost(String email, String name) {
    // log.info("로그인 정보 가져오기");
    // log.info("email {}", email);
    // log.info("name {}", name);
    // }

    // Model : spring framework
    // @PostMapping("/login")
    // public String loginPost(@ModelAttribute("mDto") LoginDto mDto,
    // @ModelAttribute("page") int page, Model model) {
    // log.info("로그인 정보 가져오기");
    // log.info("email {}", mDto.getEmail());
    // log.info("name {}", mDto.getName());
    // log.info("page {}", page);

    // // model.addAttribute("page", page); = @ModelAttribute("page")

    // // post 받고 내용 실행 후 info 로 리턴
    // return "/member/info";
    // }

    // @Valid LoginDto : LoginDto 의 유효성 검사 해줘
    @PostMapping("/login")
    public String loginPost(@Valid LoginDto mDto, BindingResult result) {
        log.info("로그인 정보 가져오기");
        log.info("email {}", mDto.getEmail());
        log.info("name {}", mDto.getName());

        // 유효성 검증을 통과하지 못한다면
        if (result.hasErrors()) {
            return "/member/login";
        }
        return "/member/info";
    }

    // 데이터 보내기 - 다음 페이지까지
    // request.setAttribute("이름", 값) == Model
    // 파라메터로 값 받아올 때는 @ModelAttribute("page") / 직접 값을 설정할 때는
    // model.addAttribute("page", page);

    // 데이터 보내기
    // request.setAttribute("이름", 값) == Model

    // /member/join + GET
    @GetMapping("/join")
    public void join(MemberDto memberDto) {
        log.info("/member/join 요청");
    }

    // /member/join + POST
    @PostMapping("/join")
    public String joinPost(@Valid MemberDto memberDto, BindingResult result) {

        // 유효성 검증을 통과하지 못한다면
        if (result.hasErrors()) {
            return "/member/join";
        }

        return "redirect:/member/login";
    }
}
