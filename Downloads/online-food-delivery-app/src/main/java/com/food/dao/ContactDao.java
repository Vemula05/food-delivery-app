package com.food.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.food.model.Contact;

public interface ContactDao extends JpaRepository<Contact,Integer> {
}
