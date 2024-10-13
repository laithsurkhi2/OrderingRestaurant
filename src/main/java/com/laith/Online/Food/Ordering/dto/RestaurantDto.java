package com.laith.Online.Food.Ordering.dto;


import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class RestaurantDto {

    private String title;

    @Column(length = 500)
    private List<String> images;

    private String description;

    private Long id;
}
