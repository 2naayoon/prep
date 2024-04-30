package com.example.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import com.example.movie.entity.Movie;
import com.example.movie.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // DELETE FROM REVIEW r WHERE movie_mno=1; → 메소드 생성 필요
    // delete(), deleteById() → Review 의 review_no 기준
    @Modifying
    @Query("delete from Review r where r.movie = :movie")
    void deleteByMovie(Movie movie);

    // movie 번호를 이용해 리뷰 가져오기
    // 이 메서드 실행 시 join 구문으로 처리해줘
    // LAZY 시 select 반복 → @EntityGraph 로 left join 으로 변경(데이터양이 많아지면 오래걸리니 join 사용)
    @EntityGraph(attributePaths = ("member"), type = EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);
}
