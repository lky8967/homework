package com.sparta.spring99_homework.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Orders {

    @Id
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "restaurantId")
    private Restaurant restaurant;

//    private Restaurant restaurant;

    @Column(nullable = false)
    private int quantity;
}
