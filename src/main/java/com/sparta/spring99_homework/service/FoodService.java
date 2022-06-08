package com.sparta.spring99_homework.service;

import com.sparta.spring99_homework.dto.FoodRequestDto;
import com.sparta.spring99_homework.model.Food;
import com.sparta.spring99_homework.model.Orders;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.FoodRepository;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FoodService {


    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Transactional
    public void create(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDto) {
            Restaurant restaurant =  restaurantRepository.findById(restaurantId).orElseThrow(
                    ()->new IllegalArgumentException("식당이 존재하지 않습니다."));

            for(FoodRequestDto a : requestDto ){
                Food food = new Food(a, restaurant);
                foodRepository.save(food);
            }

    }
}
