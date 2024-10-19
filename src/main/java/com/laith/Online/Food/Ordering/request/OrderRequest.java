package com.laith.Online.Food.Ordering.request;


import com.laith.Online.Food.Ordering.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;

    private Address deliveryAddress;


}
