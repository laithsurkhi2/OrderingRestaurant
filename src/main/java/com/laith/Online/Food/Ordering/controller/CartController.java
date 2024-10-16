package com.laith.Online.Food.Ordering.controller;


import com.laith.Online.Food.Ordering.model.CartItem;
import com.laith.Online.Food.Ordering.request.AddCartItemRequest;
import com.laith.Online.Food.Ordering.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;


    @PutMapping("/cart/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody AddCartItemRequest req,
                                                  @RequestHeader("Authorization")String jwt) throws Exception {

        CartItem cartItem= cartService.addItemToCart(req, jwt);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);

    }

    @PutMapping("/cart-item/update")
    public ResponseEntity<CartItem> updateCartItemQuantity(
            @RequestBody AddCartItemRequest req,
                                                  @RequestHeader("Authorization")String jwt) throws Exception {

        CartItem cartItem= cartService.addItemToCart(req, jwt);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);

    }



}
