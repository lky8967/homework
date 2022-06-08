package com.sparta.spring99_homework.service;

import com.sparta.spring99_homework.dto.RestaurantRequestDto;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Transactional
    public Restaurant create(Restaurant restaurant , @RequestBody RestaurantRequestDto requestDto) {


        if (requestDto.getDeliveryFee() < 0 || requestDto.getDeliveryFee() > 10000) {
            throw new IllegalArgumentException("배달비는 0원 에서 1만원 사이로 입력해주세요 ");
        } else if (requestDto.getMinOrderPrice() % 500 != 0) {
            throw new IllegalArgumentException("500원 단위로 입력해주세요 ");
        } else if (requestDto.getMinOrderPrice() < 1000 || requestDto.getMinOrderPrice() > 100000) {
            throw new IllegalArgumentException("최소 금액의 입력값은 1000원 에서 100000원 사이로 입력해 주세요 ");
        } else if (requestDto.getMinOrderPrice() % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해주세요 ");
        } else {
            return restaurantRepository.save(restaurant);
        }
    }
}
