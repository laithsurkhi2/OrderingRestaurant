package com.laith.Online.Food.Ordering.request;


import lombok.Data;

@Data
public class LoginRequest {

    private String email;
    private String password;
}