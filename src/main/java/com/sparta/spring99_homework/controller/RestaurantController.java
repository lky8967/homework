package com.sparta.spring99_homework.controller;

import com.sparta.spring99_homework.dto.RestaurantRequestDto;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import com.sparta.spring99_homework.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final RestaurantRepository restaurantRepository;

    // 서비스 방문 후 하기
    @PostMapping("api/restaurant/register")
    public Restaurant createRest(@RequestBody RestaurantRequestDto requestDto) {
        Restaurant restaurant = new Restaurant(requestDto);
            return restaurantService.create(restaurant, requestDto);

    }

    //전체 식당 조회
    @GetMapping("api/restaurants")
    public List<Restaurant> readRest(){
        return restaurantRepository.findAll();
    }


    //식당 상세 조회
//    @GetMapping("api/restaurants/{id}")
//    public Restaurant readAllRest(@PathVariable Long id){
//        Restaurant restaurant =  restaurantRepository.findById(id).orElseThrow(
//                ()->new IllegalArgumentException("식당이 존재하지 않습니다."));
//         return restaurant;
//    }


    //식당 등록
//    @PostMapping("api/restaurant/register")
//    public Restaurant createRest(@RequestBody RestaurantRequestDto requestDto){
//        Restaurant restaurant = new Restaurant(requestDto);
//        return restaurantRepository.save(restaurant);
//    }




    //    @PostMapping("api/restaurant/register")
    //    public Restaurant createRest(@RequestBody RestaurantRequestDto requestDto) {
    //        Restaurant restaurant = new Restaurant(requestDto);
    ////        if(requestDto.getDeliveryFee() < 0 || requestDto.getDeliveryFee() > 10000) {
    ////            throw new IllegalArgumentException("배달비는 0원 에서 1만원 사이로 입력해주세요 ");
    ////        } else if (requestDto.getMinOrderPrice()%500 != 0){
    ////            throw new IllegalArgumentException("500원 단위로 입력해주세요 ");
    ////        } else if (requestDto.getMinOrderPrice() < 1000 || requestDto.getMinOrderPrice() > 100000) {
    ////            throw new IllegalArgumentException("최소 금액의 입력값은 1000원 에서 100000원 사이로 입력해 주세요 ");
    ////        } else if (requestDto.getMinOrderPrice()%100 != 0) {
    ////            throw new IllegalArgumentException("100원 단위로 입력해주세요 ");
    ////        } else {
    //            return restaurantService.create(restaurant , requestDto);
    ////        }
    //    }
}
