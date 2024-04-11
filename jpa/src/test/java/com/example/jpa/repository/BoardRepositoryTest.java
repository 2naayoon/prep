package com.example.jpa.repository;

import static org.mockito.ArgumentMatchers.isNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

import javax.swing.text.html.Option;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.jpa.entity.Board;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertTest() {
        // LongStream.range(1, 100); : 1~99
        // LongStream.rangeClosed(1, 100); : 1~100
        LongStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("Title..." + i)
                    .content("Content..." + i)
                    .writer("user" + (i % 10))
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    public void readTest() {
        // l 소문자 가능 (구분 위해 L 사용)
        System.out.println(boardRepository.findById(5L));
    }

    @Test
    public void getListTest() {
        boardRepository.findAll().forEach(board -> System.out.println(board));
    }

    @Test
    public void updateTest() {
        Optional<Board> result = boardRepository.findById(26L);

        // result.get()
        result.ifPresent(board -> {
            board.setTitle("Update Title...");
            board.setContent("Update Content...");
            System.out.println(boardRepository.save(board));
        });
    }

    @Test
    public void deleteTest() {
        // entity 객체 찾기
        Optional<Board> result = boardRepository.findById(28L);

        // 삭제
        boardRepository.delete(result.get());
        System.out.println(boardRepository.findById(28L));
    }

    @Test
    public void queryMethodTest() {
        // where b1_0.title=? - Title 과 일치하는 것 x
        // Title...1 - like % 사용
        // List<Board> list = boardRepository.findByTitle("Title");
        // System.out.println("findByTitle " + list.size()); // 0

        // // where b1_0.title like ? escape '\'
        // list = boardRepository.findByTitleLike("Title");
        // System.out.println("findByTitleLike " + list.size()); // 0

        // // Title%
        // list = boardRepository.findByTitleStartingWith("Title");
        // System.out.println("findByTitleStartingWith " + list.size()); // 100

        // // %Title
        // list = boardRepository.findByTitleEndingWith("Title");
        // System.out.println("findByTitleEndingWith " + list.size()); // 0

        // // %Title%
        // list = boardRepository.findByTitleContaining("Title");
        // System.out.println("findByTitleContaining " + list.size()); // 100

        // list = boardRepository.findByWriterStartingWith("user");
        // System.out.println("findByWriterStartingWith " + list.size());

        // // where b1_0.title like ? escape '\' or b1_0.content=?
        // List<Board> list = boardRepository.findByTitleContainingOrContent("Title",
        // "Content");
        // System.out.println("findByTitleContainingOrContent " + list.size()); // 100

        // // where b1_0.title like ? escape '\' or b1_0.content like ? escape '\'
        // list = boardRepository.findByTitleContainingOrContentContaining("Title",
        // "Content");
        // System.out.println("findByTitleContainingOrContentContaining " +
        // list.size()); // 100

        // List<Board> list =
        // boardRepository.findByTitleContainingAndIdGreaterThan("Title", 50L);
        // System.out.println("findByTitleContainingAndIdGreaterThan" + list.size()); //
        // 50

        // where b1_0.id>? order by b1_0.id desc
        // List<Board> list = boardRepository.findByIdGreaterThanOrderByIdDesc(50L);
        // System.out.println("findByIdGreaterThanOrderByIdDesc" + list.size());

        // Springframwork.data.domain
        // PageRequest.of(페이지번호, 게시물 수); 페이지번호 0 부터 시작
        Pageable pageable = PageRequest.of(0, 10);
        List<Board> list = boardRepository.findByIdGreaterThanOrderByIdDesc(0L, pageable);
        list.forEach(System.out::println);

        // list.forEach(System.out::println);
    }
}
