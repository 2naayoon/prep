package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.jpa.entity.TeamMember;

// <Entity, Entity에서 pk로 쓰이는 컬럼 타입>
public interface TeamMemberRepository extends JpaRepository<TeamMember, String> {

    // sql 이 아님 (객체를 기준으로 작성해야 함)
    // TeamMember m 의 team (객체를 포함하고 있는 team 이기때문에 t로 별칭 줌)
    @Query("select m, t from TeamMember m join m.team t where t.name=?1")
    public List<TeamMember> findByMemberEqualTeam(String teamName);

}
