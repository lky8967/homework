package com.sparta.spring99_homework.dto;

import com.sparta.spring99_homework.model.Restaurant;
import lombok.Getter;

@Getter

public class RestaurantRequestDto {
    private String name;
    private Long minOrderPrice;
    private Long deliveryFee;
}
