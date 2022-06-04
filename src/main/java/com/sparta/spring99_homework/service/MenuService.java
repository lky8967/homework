package com.sparta.spring99_homework.service;

import com.sparta.spring99_homework.model.Menu;
import com.sparta.spring99_homework.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MenuService {


    private final MenuRepository menuRepository;

    @Transactional
    public Menu create(Menu menu) {
        System.out.println("서비스 문제인");
        return menuRepository.save(menu);

    }

}
