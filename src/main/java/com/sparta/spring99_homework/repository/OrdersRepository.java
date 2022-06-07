package com.sparta.spring99_homework.repository;

import com.sparta.spring99_homework.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders , Long> {
}
