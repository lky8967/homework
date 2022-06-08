package com.sparta.spring99_homework.service;

import com.sparta.spring99_homework.model.Food;
import com.sparta.spring99_homework.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class FoodService {


    private final FoodRepository foodRepository;

    @Transactional
    public Food create(Food food) {
        System.out.println("서비스 문제인");
        return foodRepository.save(food);
    }

}
