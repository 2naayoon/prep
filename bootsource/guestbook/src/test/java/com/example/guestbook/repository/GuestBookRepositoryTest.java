package com.example.guestbook.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.guestbook.entity.GuestBook;

@SpringBootTest
public class GuestBookRepositoryTest {

    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    public void testInsert() {
        IntStream.rangeClosed(1, 300).forEach(i -> {
            GuestBook guestBook = GuestBook.builder().writer("user" + (i % 10)).title("Guest Title..." + i)
                    .content("Guest Content..." + i)
                    .build();
            guestBookRepository.save(guestBook);
        });
    }

    @Test
    public void testList() {
        // 전체 리스트
        List<GuestBook> guestBooks = guestBookRepository.findAll();

        guestBooks.forEach(guestbook -> {
            System.out.println(guestbook);
        });
    }

    @Test
    public void testRow() {
        // 특정 Row 조회
        System.out.println(guestBookRepository.findById(4L));
    }

    @Test
    public void testUpdate() {
        // 특정 Row 수정
        GuestBook guestBook = guestBookRepository.findById(10L).get();
        guestBook.setTitle("수정 Title...");
        guestBook.setContent("수정 Content...");
        System.out.println(guestBookRepository.save(guestBook));
    }

    @Test
    public void testDelete() {
        // 특정 Row 삭제
        guestBookRepository.deleteById(300L);
    }
}
