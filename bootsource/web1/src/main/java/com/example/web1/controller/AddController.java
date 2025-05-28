package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.web1.dto.AddDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
@RequestMapping("/calc")
public class AddController {
    @GetMapping("/add")
    public void addGet() {
        log.info("/calc/add 요청");
    }

    // 사용자 입력 값 가져오기 (2,3번 자주 사용)
    // 1. HttpServletRequest req
    // 2. 파라메터 이용 (폼 이름과 변수명 일치)
    // 3. DTO 이용
    // - post 방식 이후 화면 컨트롤러 응답 후 보여지는 화면단에서 dto 에 들어있는 값을 사용 가능

    // post submit 이후
    // @PostMapping("/add")
    // public void addPost(HttpServletRequest req) {
    // log.info("/calc/add post 요청");
    // log.info("num1 {}", req.getParameter("num1"));
    // log.info("num2 {}", req.getParameter("num2"));
    // }

    // spring : 타입을 자동으로 변환해줌
    // String → int
    // html nmae 과 변수명 맞춰야함
    // RequestParam : 파라메터 넘어오는 이름 입력
    // @PostMapping("/add")
    // public void addPost(@RequestParam(value = "op1", defaultValue = "0") int
    // num1,
    // @RequestParam(value = "op2", defaultValue = "0") int num2) {
    // log.info("/calc/add post 요청");
    // log.info("num1 {}", num1);
    // log.info("num2 {}", num2);
    // }

    @PostMapping("/add")
    public void addPost(AddDto dto, Model model) {
        log.info("/calc/add post 요청");
        log.info("num1 {}", dto.getNum1());
        log.info("num2 {}", dto.getNum2());

        // dto.setResult(dto.getNum1() + dto.getNum2());
        model.addAttribute("result", dto.getNum1() + dto.getNum2());
    }

    // 데이터 보내기
    // request.setAttribute("이름", 값) == Model

    @GetMapping("/rules")
    public void rules() {
        log.info("/calc/rules 요청");
    }

    @PostMapping("/rules")
    public String rulesPost(AddDto addDto, @ModelAttribute("op") String op, Model model) {
        log.info("/calc/rules post 요청");
        int result = 0;
        switch (op) {
            case "+":
                result = addDto.getNum1() + addDto.getNum2();
                break;
            case "-":
                result = addDto.getNum1() - addDto.getNum2();
                break;
            case "*":
                result = addDto.getNum1() * addDto.getNum2();
                break;
            case "/":
                result = addDto.getNum1() / addDto.getNum2();
                break;
            default:
                break;
        }
        addDto.setResult(result);
        // model.addAttribute("result", result);

        return "/calc/result";
    }
}
