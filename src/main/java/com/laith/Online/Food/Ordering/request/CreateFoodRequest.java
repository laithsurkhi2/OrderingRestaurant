package com.laith.Online.Food.Ordering.request;


import com.laith.Online.Food.Ordering.model.Category;
import com.laith.Online.Food.Ordering.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data

public class CreateFoodRequest {

    private String name;
    private String description;
    private Long price;


    private Category category;
    private List<String> images;


    private Long restaurantId;
    private boolean vegetarian;
    private boolean seasonal;
    private List<IngredientsItem> ingredients;





}
