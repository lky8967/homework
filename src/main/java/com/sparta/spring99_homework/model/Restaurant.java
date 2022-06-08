package com.sparta.spring99_homework.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.spring99_homework.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
public class Restaurant {


    // ID가 자동으로 생성 및 증가합니다.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

    @JsonManagedReference // 직렬화 허용 어노테이션
    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL) // orpahRemanal = true 부모 삭제시 자식도 삭제
    private List<Food> foodList = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;

    public void setOrders(Orders orders) {
        this.orders = orders;
    }


    public Restaurant(String name , Long minOrderPrice , Long deliveryFee){
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }

    public Restaurant(RestaurantRequestDto requestDto){
        this.name = requestDto.getName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }




}
