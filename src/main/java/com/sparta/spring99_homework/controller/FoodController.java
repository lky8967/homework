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
        Food food = new Food(requestDto , restaurant);
        System.out.println(food.getName());
        System.out.println(requestDto.getName());
//        if(requestDto.getName().equals(food.getName())){
//            throw new IllegalArgumentException("같은 음식이름을 등록할 수 없습니다 ");
//        } else {
            System.out.println("food = " + food);
            return foodService.create(food);

//        }
    }

    @GetMapping("/api/restaurant/{restaurantId}/foods")
    public List<Food> readMenu(){
        return foodRepository.findAll();
    }



}
