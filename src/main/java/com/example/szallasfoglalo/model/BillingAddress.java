package com.example.szallasfoglalo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;

@Entity
@Table(name = "billing_address")
@Getter
@Setter
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int postalCode;
    private String streetName;
    private int houseNumber;
}
