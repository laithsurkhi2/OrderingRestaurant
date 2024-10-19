package com.laith.Online.Food.Ordering.controller;


import com.laith.Online.Food.Ordering.model.CartItem;
import com.laith.Online.Food.Ordering.model.Order;
import com.laith.Online.Food.Ordering.model.User;
import com.laith.Online.Food.Ordering.request.AddCartItemRequest;
import com.laith.Online.Food.Ordering.request.OrderRequest;
import com.laith.Online.Food.Ordering.service.OrderService;
import com.laith.Online.Food.Ordering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;


    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                                  @RequestHeader("Authorization")String jwt) throws Exception {

        User user= userService.findUserByJwtToken(jwt);

        Order order= orderService.createOrder(req,user);
        return new ResponseEntity<>(order, HttpStatus.OK);

    }

    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                             @RequestHeader("Authorization")String jwt) throws Exception {

        User user= userService.findUserByJwtToken(jwt);

        List<Order> orders= orderService.getUsersOrder(user.getId());
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }


}
