package com.laith.Online.Food.Ordering.controller;


import com.laith.Online.Food.Ordering.model.Food;
import com.laith.Online.Food.Ordering.model.Restaurant;
import com.laith.Online.Food.Ordering.model.User;
import com.laith.Online.Food.Ordering.request.CreateFoodRequest;
import com.laith.Online.Food.Ordering.response.MessageResponse;
import com.laith.Online.Food.Ordering.service.FoodService;
import com.laith.Online.Food.Ordering.service.RestaurantService;
import com.laith.Online.Food.Ordering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {


    @Autowired
    private FoodService foodService;


    @Autowired
    private UserService userService;


    @Autowired
    private RestaurantService restaurantService;


    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt) throws Exception {

        User user= userService.findUserByJwtToken(jwt);
        Restaurant restaurant= restaurantService.findRestaurantbyId(req.getRestaurantId());
        Food food= foodService.createFood(req, req.getCategory(), restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {

        User user= userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);

        MessageResponse response= new MessageResponse();
        response.setMessage("Food deleted succesfully"); //here


        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvailabilityStatus(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String jwt) throws Exception {

        User user= userService.findUserByJwtToken(jwt);

        Food food= foodService.updateAvailabilityStatus(id);




        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

}
