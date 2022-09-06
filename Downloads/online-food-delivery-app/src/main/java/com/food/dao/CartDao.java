package com.food.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.Cart;

public interface CartDao extends JpaRepository<Cart,Integer> {
}
