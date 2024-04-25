package com.example.movie.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = { "member", "movie" }) // 정보를 같이 갖고 가지 말라고 빼줌
@Builder
@Entity
public class Review extends BaseEntity {

    // reviewNo (id, 시퀀스)
    @SequenceGenerator(name = "review_seq_gen", sequenceName = "review_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_seq_gen")
    @Id
    private Long reviewNo;

    // grade(int)
    private int grade;

    // text(String)
    private String text;

    // Movie와 Member = M:N 관계를 위해 review 작성 (M:1 / N:1)

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

}
