package com.example.movie.service;

import com.example.movie.dto.MemberDto;
import com.example.movie.dto.PasswordChangeDto;
import com.example.movie.entity.Member;
import com.example.movie.entity.Movie;

public interface MovieUserService {
    // 회원가입
    String register(MemberDto insertDto) throws IllegalStateException;

    // 닉네임 수정
    void nickNameUpdate(MemberDto upMemberDto);

    // 비밀번호 수정
    void passwordUpdate(PasswordChangeDto pDto) throws IllegalStateException;

    // 회원탈퇴
    void leave(MemberDto leaveMemberDto);

    // 해주는 라이브러리 있음
    // dto → entity
    public default Member dtoToEntity(MemberDto dto) {

        return Member.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
    }

    // entity → dto
    public default MemberDto entityToDto(Member entity) {
        return MemberDto.builder()
                .mid(entity.getMid())
                .email(entity.getEmail())
                .nickname(entity.getNickname())
                .password(entity.getPassword())
                .role(entity.getRole())
                .build();
    }

}
