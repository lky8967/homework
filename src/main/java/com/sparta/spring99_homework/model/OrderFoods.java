package com.sparta.spring99_homework.model;

import javax.persistence.Id;

public class OrderFoods {

    @Id
    private Long id;

    private String name;
    private int quantity;
    private Long price;


}
