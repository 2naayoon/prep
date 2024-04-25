package com.example.movie.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class ReviewDto {
    private Long reviewNo;
    private int grade;
    private String text;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    // 관계 맺은 것들을 dto에서 표현할 때 (화면에 보여지는 거에 따라 작성)
    // Member : 필드로 풀어서 가져옴
    // private Member member; // Member 다 쓸 때
    private Long mid;
    private String email;
    private String nickname;

    // Movie
    // private Movie movie; // Movie 다 쓸 때
    private Long mno;
}
