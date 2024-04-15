package com.example.book.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.book.dto.BookDto;
import com.example.book.dto.PageRequestDto;
import com.example.book.dto.PageResultDto;
import com.example.book.entity.Book;
import com.example.book.service.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@RequestMapping("/book")
@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService service;

    @GetMapping("/list")
    public void list(Model model, @ModelAttribute("requestDto") PageRequestDto requestDto) {
        log.info("list 요청");
        PageResultDto<BookDto, Book> result = service.getList(requestDto);
        model.addAttribute("result", result);
    }

    // 페이지 나누기 후 바뀌는 정보
    // id=355&page=1&type=&keyword=

    @GetMapping(value = { "/read", "/modify" })
    public void read(@RequestParam Long id, Model model, @ModelAttribute("requestDto") PageRequestDto requesDto) {
        log.info("read 요청", id);

        model.addAttribute("bookDto", service.getRow(id));
    }

    @GetMapping(value = { "/create" })
    public void create(BookDto dto, Model model, @ModelAttribute("requestDto") PageRequestDto requesDto) {
        log.info("create 요청");

        // 테이블에 있는 카테고리 명 보여주기
        model.addAttribute("categories", service.categoryNameList());
    }

    // BookDto dto - 안 붙이면 이름이 bookDto
    // @ModelAttribute("dto") - 이름을 dto 로 변경
    // 내용이 담겨져 있기 때문에 굳이 @ModelAttribute 안 써도 됨
    // int page 등 개별 변수로 받을 때 사용 - @ModelAttribute("page") int page
    @PostMapping("/create")
    public String postCreate(@Valid BookDto dto, BindingResult result, RedirectAttributes rttr, Model model,
            @ModelAttribute("requestDto") PageRequestDto requesDto) {
        log.info("book post 요청 {}", dto);

        if (result.hasErrors()) {
            model.addAttribute("categories", service.categoryNameList());
            return "/book/create";
        }

        // insert 작성
        Long id = service.bookCreate(dto);

        // 페이지 나누기 정보
        rttr.addAttribute("page", requesDto.getPage());
        rttr.addAttribute("type", requesDto.getType());
        rttr.addAttribute("keyword", requesDto.getKeyword());

        rttr.addFlashAttribute("msg", id);
        return "redirect:/book/list";
    }

    @PostMapping("/modify")
    public String postModify(BookDto updateDto, RedirectAttributes rttr,
            @ModelAttribute("requestDto") PageRequestDto requesDto) {
        log.info("업데이트 요청 {}", updateDto);
        // page 나누기 정보 PageRequestDto(page=2, size=10, type=, keyword=)
        log.info("page 나누기 정보 {}", requesDto);
        Long id = service.bookUpdate(updateDto);

        // 조회화면으로 이동
        rttr.addAttribute("id", id);
        // 페이지 나누기 정보
        rttr.addAttribute("page", requesDto.getPage());
        rttr.addAttribute("type", requesDto.getType());
        rttr.addAttribute("keyword", requesDto.getKeyword());
        return "redirect:/book/read";
    }

    @PostMapping("/delete")
    public String postDelete(Long id, RedirectAttributes rttr, @ModelAttribute("requestDto") PageRequestDto requesDto) {
        log.info("도서 삭제 요청 {}", id);
        service.bookDelete(id);

        // 페이지 나누기 정보
        rttr.addAttribute("page", requesDto.getPage());
        rttr.addAttribute("type", requesDto.getType());
        rttr.addAttribute("keyword", requesDto.getKeyword());

        return "redirect:/book/list";
    }

}
