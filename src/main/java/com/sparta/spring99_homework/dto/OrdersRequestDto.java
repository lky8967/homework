package com.sparta.spring99_homework.dto;

import com.sparta.spring99_homework.model.Food;
import com.sparta.spring99_homework.model.Restaurant;
import lombok.Getter;

@Getter
public class OrdersRequestDto {
    private Restaurant restaurantId;
    private Food foods;
//    private int quantity;
}
