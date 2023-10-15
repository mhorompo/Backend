package com.example.szallasfoglalo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int price;
    private int capacity;
    private int roomNumber;
    private roomType roomType;

    public Room(int id, int price, int capacity, int roomNumber, com.example.szallasfoglalo.model.roomType roomType) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    public Room() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public com.example.szallasfoglalo.model.roomType getRoomType() {
        return roomType;
    }

    public void setRoomType(com.example.szallasfoglalo.model.roomType roomType) {
        this.roomType = roomType;
    }
}
