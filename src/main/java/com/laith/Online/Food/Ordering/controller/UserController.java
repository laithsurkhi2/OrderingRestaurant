package com.laith.Online.Food.Ordering.controller;

import com.laith.Online.Food.Ordering.model.User;
import com.laith.Online.Food.Ordering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization") String jwt) throws Exception {
        // Strip the "Bearer " part from the token if it exists
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7);
        }

        // Validate and process the token
        User user = userService.findUserByJwtToken(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}

