package com.sparta.spring99_homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.spring99_homework.dto.MenuRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Menu {


    @Id
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonBackReference // 순환 참조 방지
    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;


    @Column(nullable = false , unique = true)
    private String name;

    @Column(nullable = false)
    private Long price;


    public Menu(String name, Long price ){
        this.name = name;
        this.price = price;
    }


    public Menu(MenuRequestDto requestDto, Restaurant restaurant){
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
        this.restaurant = restaurant;

    }




}
