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
    public void createMenu(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDto ){
        foodService.create(restaurantId,requestDto );
    }

    @GetMapping("/api/restaurant/{restaurantId}/foods")
    public List<Food> readMenu(){
        return foodRepository.findAll();
    }



}
