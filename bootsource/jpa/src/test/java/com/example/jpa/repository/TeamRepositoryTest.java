package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Team;
import com.example.jpa.entity.TeamMember;

import jakarta.transaction.Transactional;

@SpringBootTest
public class TeamRepositoryTest {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMemberRepository teamMemberRepository;

    @Test
    public void insertTest() {
        // 팀 정보 삽입
        Team team1 = teamRepository.save(Team.builder().id("team1").name("팀1").build());
        Team team2 = teamRepository.save(Team.builder().id("team2").name("팀2").build());
        Team team3 = teamRepository.save(Team.builder().id("team3").name("팀3").build());

        // 회원 정보 삽입
        teamMemberRepository.save(TeamMember.builder().id("member1").userName("홍길동").team(team1).build());
        teamMemberRepository.save(TeamMember.builder().id("member2").userName("성춘향").team(team2).build());
        teamMemberRepository.save(TeamMember.builder().id("member3").userName("이순신").team(team2).build());
        teamMemberRepository.save(TeamMember.builder().id("member4").userName("정우성").team(team3).build());
    }

    // 연관관계가 있는 데이터 조회
    // 1. 다대일(멤버:팀) 관계에서는 기본적으로 1에 해당하는 엔티티 정보를 가지고 나옴
    // → FetchType.EAGER 기본값 (갖고 나와)
    // → 멤버를 조회하면 팀 정보도 같이 조회 (객체 그래프 탐색으로 접근 가능)
    // → 객체지향쿼리 작성

    // 2. 일대다(팀:멤버) 관계에서는 다에 해당하는 엔티티를 안 가지고 나옴
    // → FetchType.LAZY 기본값 (가지고 나오지 마)

    // FetchType : 연결관계에서 상대 정보를 같이 가지고 나올건지 말건지 여부
    // FetchType.EAGER : : 갖고 나옴
    // FetchType.LAZY : 안 갖고 나옴

    @Test
    public void getRowTest() {

        // team_member(N) : team(1) → 외래키 제약조건
        // member 를 찾을 때 N:1 관계에서는 1 에 해당하는 정보도 기본으로 가지고 옴

        // select tm1_0.member_id, t1_0.team_id, t1_0.team_name, tm1_0.user_name
        // from team_member tm1_0 left join team t1_0
        // on t1_0.team_id=tm1_0.team_team_id
        // where tm1_0.member_id=?
        TeamMember teamMember = teamMemberRepository.findById("member1").get();

        System.out.println(teamMember); // TeamMember(id=member1, userName=홍길동, team=Team(id=team1, name=팀1))
        // 객체 그래프 탐색
        System.out.println("팀 전체 정보 " + teamMember.getTeam()); // TeamMember(id=team1, name=팀1)
        System.out.println("팀 명 : " + teamMember.getTeam().getName()); // Team1

        // 회원 조회 시 나와 같은 팀에 소속된 회원 조회
        // SELECT *
        // FROM TEAM_MEMBER tm JOIN TEAM t ON tm.TEAM_TEAM_ID =t.TEAM_ID
        // WHERE tm.team_team_id = '팀2';
        teamMemberRepository.findByMemberEqualTeam("팀2").forEach(member -> {
            System.out.println(member);
        });
    }

    @Test
    public void updateTest() {
        // 멤버의 팀 변경
        // 수정할 회원 조회
        TeamMember member = teamMemberRepository.findById("member3").get();
        Team team = Team.builder().id("team3").build();
        member.setTeam(null);

        System.out.println("수정 후 " + teamMemberRepository.save(member));
    }

    @Test
    public void deleteTest() {
        // 팀원 삭제 먼저! or 팀원 팀을 null 로 설정
        TeamMember member = teamMemberRepository.findById("member1").get();
        member.setTeam(null);
        teamMemberRepository.save(member);

        // 팀 삭제
        teamRepository.deleteById("team1");
    }

    // OneToMany 설정 기준으로
    // 팀을 기준으로 회원 조회?
    // @Transactional
    @Test
    public void getMemberList() {
        Team team = teamRepository.findById("team3").get();

        System.out.println(team);

        // *Error : LazyInitializationException : ToString() - members 변수를 출력하려고 했기때문
        // 1. @Transactional
        // 2. FetchType.EAGER 로 변경
        team.getMembers().forEach(m -> System.out.println(m));
    }
}
