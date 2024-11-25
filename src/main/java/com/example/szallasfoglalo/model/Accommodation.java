package com.example.szallasfoglalo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "accommodation")
@Getter
@Setter
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String zipCode;
    private String streetName;
    @Column(length = 1000000000)
    private String description;
    private String latitude;
    private String longitude;
    private int price;
    private boolean freeParking;
    private boolean freeWifi;
    private boolean breakfastIncluded;
    private boolean airConditioning;
    private boolean reception;
    private boolean barrierFree;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "accommodation", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Image> images;
}
