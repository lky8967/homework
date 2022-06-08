package com.sparta.spring99_homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.spring99_homework.dto.OrdersRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class OrderFoods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @JsonBackReference // 순환 참조 방지
    @ManyToOne
    @JoinColumn(name = "ordersId")
    private Orders orders;

    @Column(nullable = false)
    private int quantity;

    public OrderFoods( int quantity ){
        this.quantity = quantity;
    }

    public OrderFoods(OrdersRequestDto requestDto , Orders orders){
        this.orders = orders;
//        this.quantity = requestDto.getFoods();
    }

}
