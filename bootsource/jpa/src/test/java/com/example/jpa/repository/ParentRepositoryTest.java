package com.example.jpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.jpa.entity.Child;
import com.example.jpa.entity.Parent;

import jakarta.transaction.Transactional;

@SpringBootTest
public class ParentRepositoryTest {

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private ChildRepository childRepository;

    @Test
    public void insertTest() {
        // Parent p = Parent.builder().name("parent2").build();
        // parentRepository.save(p);

        // Child c1 = Child.builder().name("child1").parent(p).build();
        // childRepository.save(c1);
        // Child c2 = Child.builder().name("child2").parent(p).build();
        // childRepository.save(c2);

        // 부모 한 명에 자식 2명
        Parent p = Parent.builder().name("parent3").build();

        Child c1 = Child.builder().name("child1").parent(p).build();
        p.getChildList().add(c1);
        Child c2 = Child.builder().name("child2").parent(p).build();
        p.getChildList().add(c2);

        parentRepository.save(p);
        // childRepository.save(c1);
        // childRepository.save(c2);
    }

    @Test
    public void deleteTest() {
        // 부모가 자식을 가지고 있는 경우 삭제 시 자식의 부모 아이디 변경 후 부모 삭제
        Parent p = Parent.builder().id(1L).build();

        // 부모를 null 로 지정
        // Child c1 = Child.builder().id(1L).parent(null).build();
        // Child c2 = Child.builder().id(2L).parent(null).build();
        // c1.setParent(null);
        // c2.setParent(null);
        // childRepository.save(c1);
        // childRepository.save(c2);

        // 자식 지운 후 부모 삭제
        Child c1 = Child.builder().id(1L).build();
        childRepository.delete((c1));
        Child c2 = Child.builder().id(2L).build();
        childRepository.delete((c2));

        parentRepository.delete(p);
    }

    @Test
    public void deleteCascadeTest() {
        // 부모 한 명에 자식 2명
        Parent p = Parent.builder().id(2L).build();

        Child c1 = Child.builder().id(52L).build();
        p.getChildList().add(c1);
        Child c2 = Child.builder().id(53L).build();
        p.getChildList().add(c2);

        parentRepository.delete(p);
    }

    // @Transactional
    @Test
    public void deleteOrphanTest() {
        // 기존 자식 여부 확인
        Parent p = parentRepository.findById(102L).get();

        // FetchType 이 LAZY인 경우 오류 발생
        // select 구문이 또 들어감(LAZY 방식이라)
        System.out.println("기존 자식 " + p.getChildList());

        p.getChildList().remove(0); // 인덱스 제거 → childList 에서 제거 → 엔티티 제거
        parentRepository.save(p);
    }
}
