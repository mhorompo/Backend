package com.example.szallasfoglalo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaymentDto {
    private String date;
    private int price;
}
