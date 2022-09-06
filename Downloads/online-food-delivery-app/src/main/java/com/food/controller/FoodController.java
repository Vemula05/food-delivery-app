package com.food.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.food.dao.FoodDaoImpl;
import com.food.model.Food;

import java.util.List;


@RestController
@CrossOrigin
public class FoodController {

    @Autowired
    FoodDaoImpl foodDao;

    @RequestMapping(value = "/menu")
    public List<Food> getMenu(Model model) {
        List<Food> foodItems ;
        foodItems = foodDao.getFoodList();
        return foodItems;
    }


}
