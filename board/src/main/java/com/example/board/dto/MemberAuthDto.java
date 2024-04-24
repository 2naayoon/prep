package com.example.board.dto;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

// 회원 정보 + 허가와 관련된 정보(사이트를 접근 여부)
@Data
public class MemberAuthDto extends User {

    private MemberDto memberDto;

    public MemberAuthDto(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
    // List<T>, List<E> : 리스트에 객체 타입으로 아무거나 담아도 됨
    // <? extends GrantedAuthority> : GrantedAuthority가 부모인 자식들만 담을 수 있음 (자식 타입 제한)
    // List<GrantedAuthority>, List<SimpleGrantedAuthority>, Set<GrantedAuthority>,
    // ...
    // GrantedAuthority 자식 확인 : 자바 api 검색

    public MemberAuthDto(MemberDto memberDto) {
        super(memberDto.getEmail(), memberDto.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + memberDto.getMemberRole())));
        this.memberDto = memberDto;
    }
}
