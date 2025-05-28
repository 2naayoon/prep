package com.example.guestbook.service;

import com.example.guestbook.dto.GuestBookDto;
import com.example.guestbook.dto.PageRequestDto;
import com.example.guestbook.dto.PageResultDto;
import com.example.guestbook.entity.GuestBook;

public interface GuestBookService {
    // 페이지 나누기 전
    // List<GuestBookDto> getList();

    // 페이지 나누기 후
    // PageResultDto<DTO,EN> : dto, entity 지정
    PageResultDto<GuestBookDto, GuestBook> getList(PageRequestDto requestDto);

    GuestBookDto getRow(Long gno);

    void modify(GuestBookDto dto);

    void remove(Long gno);

    Long create(GuestBookDto dto);

    // entity → dto
    public default GuestBookDto entityToDto(GuestBook guestBook) {
        return GuestBookDto.builder()
                .gno(guestBook.getGno())
                .title(guestBook.getTitle())
                .writer(guestBook.getWriter())
                .content(guestBook.getContent())
                .createdDate(guestBook.getCreatedDate())
                .lastModifiedDate(guestBook.getLastModifiedDate())
                .build();
    }

    // dto → entity
    public default GuestBook dtoToEntity(GuestBookDto dto) {
        return GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .writer(dto.getWriter())
                .content(dto.getContent())
                .build();
    }
}
