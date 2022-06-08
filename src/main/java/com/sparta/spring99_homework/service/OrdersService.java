package com.sparta.spring99_homework.service;

import com.sparta.spring99_homework.dto.OrdersRequestDto;
import com.sparta.spring99_homework.model.Orders;
import com.sparta.spring99_homework.model.Restaurant;
import com.sparta.spring99_homework.repository.OrdersRepository;
import com.sparta.spring99_homework.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final OrdersRepository ordersRepository;
    private final RestaurantRepository restaurantRepository;
    public Orders create( @RequestBody List<OrdersRequestDto> ordersRequestDto) {
        for (OrdersRequestDto a : ordersRequestDto) {

            Restaurant restaurant = restaurantRepository.findById(a.getRestaurantId().getId()).orElseThrow(
                    () -> new IllegalArgumentException("식당이 존재하지 않습니다."));
            String restName = restaurant.getName();
            System.out.println("restaurant = " + restaurant);
            System.out.println("restName = " + restName);
        }
        Orders orders = new Orders();
        return ordersRepository.save(orders);

    }
}
