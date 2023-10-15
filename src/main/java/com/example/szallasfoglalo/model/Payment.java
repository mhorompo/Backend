package com.example.szallasfoglalo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int amount;
    private LocalDateTime date;

    private PaymentType paymentType;

    public Payment() {
    }

    public Payment(int id, int amount, LocalDateTime date, PaymentType paymentType) {
        this.id = id;
        this.amount = amount;
        this.date = date;
        this.paymentType = paymentType;
    }
}