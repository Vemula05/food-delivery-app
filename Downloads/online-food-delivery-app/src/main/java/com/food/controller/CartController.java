package com.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.food.dao.CartDaoImpl;
import com.food.model.NewCart;

import java.io.IOException;

@RestController
@CrossOrigin
public class CartController {

    @Autowired
    CartDaoImpl cartDaoImpl;


    @PostMapping("/cart")
    public int getTotal(@RequestBody NewCart[] cart, Model model){
    	cartDaoImpl.saveToCart(cart);
        return cartDaoImpl.claculateTotal(cart);
    }

    @RequestMapping("/changeDB")
    public boolean changeDB(){
    	cartDaoImpl.updateDB();
        return true;
    }

    @PostMapping("/addToCart")
    public NewCart[] increaseQuantity(@RequestBody NewCart[] cart, Model model){
    	cartDaoImpl.addItems(cart);
        return cart;
    }

    @PostMapping("/addNewItem")
    public boolean addNewItem(@RequestParam("file") MultipartFile file, @RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartDaoImpl.addNewItem(file,newFoodData);
    }


    @PostMapping("/addNewItemUrl")
    public boolean addNewItemByUrl(@RequestParam("newFoodItem") String newFoodData) throws IOException {
        return cartDaoImpl.addNewItemWithUrl(newFoodData);
    }

    @PostMapping("/checkItemId")
    public boolean checkItemId(@RequestBody String itemId, Model model){
        return !cartDaoImpl.itemIdAvailable(itemId);
    }
}
