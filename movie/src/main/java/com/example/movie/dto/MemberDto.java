package com.example.movie.dto;

import java.time.LocalDateTime;

import com.example.movie.constant.MemberRole;

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
public class MemberDto {
    private Long mid;
    private String email;
    private String password;
    private String nickname;
    private MemberRole role;

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
