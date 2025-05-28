package com.example.movie.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.movie.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // 오라클이 아니라면 간단하게 표현 가능 - 다른 db
    // @Query("select m, avg(r.grade), count(distinct r) from Movie m left join
    // Review r on r.movie = m group by m")

    // @Query("select m, min(mi), avg(r.grade), count(distinct r) from Movie m left
    // join MovieImage mi on mi.movie = m " +
    // "left join Review r on r.movie = m group by m")
    // Page<Object[]> getListPage2(Pageable pageable);

    @Query(value = "SELECT * FROM  MOVIE m " +
            "LEFT JOIN (SELECT r.MOVIE_MNO, COUNT(*), AVG(r.GRADE) FROM REVIEW r GROUP BY r.MOVIE_MNO) r1 " +
            "ON m.MNO = r1.movie_mno " +
            "LEFT JOIN (SELECT mi.* FROM MOVIE_IMAGE mi WHERE mi.INUM " +
            "IN (SELECT MIN(mi2.INUM) FROM MOVIE_IMAGE mi2 GROUP BY mi2.MOVIE_MNO)) A " +
            "ON m.MNO = A.movie_mno " +
            "ORDER BY MNO DESC", nativeQuery = true)
    Page<Object[]> getListPage(Pageable pageable);

}
