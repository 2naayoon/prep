package com.example.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReplyDto {
    private Long rno;
    private String text;
    private String replyer;
    private Long bno;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
