package com.example.szallasfoglalo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AccommodationDto {
    private String name;
    private String city;
    private String zipCode;
    private String streetName;
    private String description;
    private String longitude;
    private String latitude;
    private int userId;
    private int price;
}
