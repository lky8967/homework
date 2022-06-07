package com.sparta.spring99_homework.service;

import com.sparta.spring99_homework.dto.RestaurantRequestDto;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant create(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }
}
