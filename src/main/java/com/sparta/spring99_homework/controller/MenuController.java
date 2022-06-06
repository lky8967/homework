package com.sparta.spring99_homework.controller;

import com.sparta.spring99_homework.dto.MenuRequestDto;
import com.sparta.spring99_homework.model.Menu;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.MenuRepository;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import com.sparta.spring99_homework.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
public class MenuController {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;
    private final MenuService menuService;

    @PostMapping("/api/restaurant/{restaurantId}/food/register")
    public Menu createMenu(@RequestBody MenuRequestDto requestDto, @PathVariable Long restaurantId ){
        Restaurant restaurant =  restaurantRepository.findById(restaurantId).orElseThrow(
                ()->new IllegalArgumentException("식당이 존재하지 않습니다."));
        System.out.println("restaurant = " + restaurant);
        Menu menu = new Menu(requestDto , restaurant);
        System.out.println("menu = " + menu);
        return menuService.create(menu);
    }

    @GetMapping("/api/restaurant/{restaurantId}/foods")
    public List<Menu> readMenu(){
        return menuRepository.findAll();
    }



}
