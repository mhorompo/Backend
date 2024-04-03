package com.example.szallasfoglalo.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ReservationDto {
    private String startDate;
    private String endDate;
    private int price;
    private String transactionId;
}
