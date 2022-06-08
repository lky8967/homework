package com.sparta.spring99_homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.spring99_homework.dto.OrdersRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Orders {

    @Id
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference // 순환 참조 방지
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

    @Column(nullable = false)
    private int quantity;

//    public Orders(int quantity){
//        this.quantity = quantity;
//    }

    public Orders(OrdersRequestDto requestDto , Restaurant restaurant){
        this.quantity = requestDto.getQuantity();
        this.restaurant = restaurant;
    }

}
