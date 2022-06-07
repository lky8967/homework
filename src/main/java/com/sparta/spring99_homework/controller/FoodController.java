package com.sparta.spring99_homework.controller;

import com.sparta.spring99_homework.dto.FoodRequestDto;
import com.sparta.spring99_homework.model.Food;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.FoodRepository;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import com.sparta.spring99_homework.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodService foodService;

    @PostMapping("/api/restaurant/{restaurantId}/food/register")
    public Food createMenu(@RequestBody FoodRequestDto requestDto, @PathVariable Long restaurantId ){
        Restaurant restaurant =  restaurantRepository.findById(restaurantId).orElseThrow(
                ()->new IllegalArgumentException("식당이 존재하지 않습니다."));
        System.out.println("restaurant = " + restaurant);
        Food menu = new Food(requestDto , restaurant);
        System.out.println("menu = " + menu);
        return foodService.create(menu);
    }

    @GetMapping("/api/restaurant/{restaurantId}/foods")
    public List<Food> readMenu(){
        return foodRepository.findAll();
    }



}
