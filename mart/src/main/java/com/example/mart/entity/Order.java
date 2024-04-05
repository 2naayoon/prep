package com.example.mart.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "orderItems")
@Table(name = "orders") // table 명 order 사용불가
@Entity
public class Order {

    @SequenceGenerator(name = "mart_order_seq_gen", sequenceName = "order_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mart_order_seq_gen")
    @Id
    @Column(name = "order_id")
    private Long id; // 주문번호

    @ManyToOne
    private Member member;

    @CreatedDate
    private LocalDateTime orderDate;

    // 주문상태 - ORDER, CANCEL (상수를 스트링으로 바꿔서 넣어줘)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Builder.Default // 반대쪽은 무조건 리스트 (여러 개)
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER) // onetomany 쪽에선 무조건 mappedby
    private List<OrderItem> orderItems = new ArrayList<>(); // 빌더로 하면 안 떠서 어레이리스트 강제로 넣어줌
}
