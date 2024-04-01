package com.example.web1.controller;

import org.springframework.stereotype.Controller;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Log4j2
@Controller
public class HomeController {
    // *Error : TemplateInputException: Error resolving template [], template might
    // not exist or might not be accessible by any of the configured Template
    // Resolvers

    // value : "제공할 서비스 주소", .GET : get 방식 요청
    // @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping("/") // RequestMapping 보다 좀 더 간단
    public String home() {
        // c.e.web1.controller.HomeController : home 요청
        // log = sout
        log.info("home 요청");

        // templates 아래 경로부터 시작, 확장자 빼고 파일명만
        return "index";
    }
}
