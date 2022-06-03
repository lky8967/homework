package com.sparta.spring99_homework.controller;

import com.sparta.spring99_homework.dto.RestaurantRequestDto;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import com.sparta.spring99_homework.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    // 서비스 방문 후 하기
    @PostMapping("api/restaurant/register")
    public Restaurant createRest(@RequestBody RestaurantRequestDto requestDto){
        Restaurant restaurant = new Restaurant(requestDto);
        return restaurantService.create(restaurant);
    }


    //식당 등록
//    @PostMapping("api/restaurant/register")
//    public Restaurant createRest(@RequestBody RestaurantRequestDto requestDto){
//        Restaurant restaurant = new Restaurant(requestDto);
//        return restaurantRepository.save(restaurant);
//    }

    //전체 식당 조회
    @GetMapping("api/restaurants")
    public List<Restaurant> readRest(){
        return restaurantRepository.findAll();
    }

}
