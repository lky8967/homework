package com.sparta.spring99_homework.repository;

import com.sparta.spring99_homework.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository <Restaurant , Long> {


//    List<Restaurant> findAllByOrderByCreatedAtDesc();
}
