package com.sparta.spring99_homework.controller;

import com.sparta.spring99_homework.model.Orders;
import com.sparta.spring99_homework.repository.OrdersRepository;
import com.sparta.spring99_homework.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrdersController {

    private final OrdersRepository ordersRepository;
    private final OrdersService ordersService;

    //주문
//    @PostMapping("/api/order/request")
//    public Orders create(){
//        return ordersService.create();
//    }



    //주문조회
    @GetMapping("api/orders")
    public List<Orders> readOrders(){
        return ordersRepository.findAll();
    }



}
