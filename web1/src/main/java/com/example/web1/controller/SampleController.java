package com.example.web1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/sample")
public class SampleController {
    // String, void 형태의 메서드 작성
    // *Error
    // 404 - 경로 없음 (컨트롤러에 매핑 주소 확인)
    // 400 - Bad Request
    // * MethodArgumentTypeMismatchException: Failed to convert value of type
    // 'java.lang.String' to required type 'int'; For input string: ""
    // 500 - template
    // * Error resolving template [sample/basic], template might not exist or might
    // not be accessible by any of the configured Template Resolvers
    // 템플릿 없음 → 템플릿 폴더 확인

    // 리턴타입 결정
    // void : 경로와 일치하는 곳에 템플릿이 존재할 때
    // String : 경로와 일치하는 곳에 템플릿이 없을 때(템플릿의 위치와 관계없이 자유롭게 지정 가능)

    // 마지막 html 파일 - 앞에 있는 건 무조건 template 뒤의 경로
    // http://localhost:8080/board/create
    // http://localhost:8080/board/user/create
    // http://localhost:8080/board/user/member/create

    // http://localhost:8080/sample/basic 요청

    // @GetMapping("/sample/basic")
    // @RequestMapping("/sample") 설정 시 앞 경로 생략 가능
    @GetMapping("/basic")
    public void basic() {
        log.info("/sample/basic 요청");
    }

    @GetMapping("/ex1")
    public void ex1() {
        log.info("/sample/ex1 요청");
    }

    @GetMapping("/ex2")
    public String ex2() {
        log.info("/sample/ex2 요청");
        return "/index";
    }

}
