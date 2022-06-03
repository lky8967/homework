package com.sparta.spring99_homework.model;

import com.sparta.spring99_homework.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Restaurant {


    @Id
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String restName;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;


    public Restaurant(String restName , Long minOrderPrice , Long deliveryFee){
        this.restName = restName;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }


    public Restaurant(RestaurantRequestDto requestDto){
        this.restName = requestDto.getRestName();
        this.minOrderPrice = requestDto.getMinOrderPrice();
        this.deliveryFee = requestDto.getDeliveryFee();
    }

}
