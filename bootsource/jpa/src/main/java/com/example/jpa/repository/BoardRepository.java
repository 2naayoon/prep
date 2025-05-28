package com.example.jpa.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.Board;
import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    // id로 찾기(List<Board> findById(Long id);), 전체 찾기
    @Query(value = "SELECT * FROM pro_board", nativeQuery = true)
    List<Board> findList();

    // title 로 찾기
    // @Query 붙이면 쿼리어노테이션 우선 동작
    @Query("SELECT b FROM Board b WHERE b.title = %?1%")
    List<Board> findByTitle(String title);

    // writer 로 찾기
    @Query("SELECT b FROM Board b WHERE b.writer LIKE %:writer%")
    List<Board> findByWriter(String writer);

    // like
    List<Board> findByTitleLike(String title);

    List<Board> findByTitleStartingWith(String title);

    List<Board> findByTitleEndingWith(String title);

    List<Board> findByTitleContaining(String title);

    // writer 가 user 시작하는 작성자 찾기
    List<Board> findByWriterStartingWith(String writer);

    // title 이 Title 문자열이 포함되어 있거나
    // content 가 Content 문자열이 포함되어 있는
    // %Title% or = Content
    @Query("SELECT b FROM Board b WHERE b.title LIKE %:title% OR b.content = :content")
    List<Board> findByTitleContainingOrContent(String title, String content);

    List<Board> findByTitleContainingOrContentContaining(String title, String content);

    // title 이 Title 문자열이 포함되어 있고, id 가 50 보다 큰 게시물 조회
    @Query("SELECT b FROM Board b WHERE b.title LIKE %?1% and b.id > ?2")
    List<Board> findByTitleContainingAndIdGreaterThan(String title, Long id);

    // id 가 50 보다 큰 게시물 조회 시 내림차순 정렬
    List<Board> findByIdGreaterThanOrderByIdDesc(Long id);

    List<Board> findByIdGreaterThanOrderByIdDesc(Long id, Pageable Pageable);

}
