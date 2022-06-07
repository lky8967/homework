package com.sparta.spring99_homework.repository;

import com.sparta.spring99_homework.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FoodRepository extends JpaRepository<Food , Long> {

}
