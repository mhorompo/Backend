package com.example.szallasfoglalo.controller;

import com.example.szallasfoglalo.model.Accommodation;
import com.example.szallasfoglalo.model.Reservation;
import com.example.szallasfoglalo.model.dto.DateDto;
import com.example.szallasfoglalo.service.AccommodationService;
import com.example.szallasfoglalo.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(value = "*", maxAge = 0)
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reserveAccommodation/{userId}/{accommodationId}")
    public Reservation reserveAccommodation(@PathVariable int userId, @PathVariable int accommodationId, @RequestBody DateDto data){
        return this.reservationService.newReservation(userId, accommodationId, data);
    }
}
