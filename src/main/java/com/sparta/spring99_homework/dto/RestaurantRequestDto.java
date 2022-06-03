package com.sparta.spring99_homework.dto;

import lombok.Getter;

@Getter

public class RestaurantRequestDto {
    private String restName;
    private Long minOrderPrice;
    private Long deliveryFee;
}
