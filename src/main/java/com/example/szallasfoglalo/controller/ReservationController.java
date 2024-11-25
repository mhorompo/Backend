package com.example.szallasfoglalo.controller;

import com.example.szallasfoglalo.model.Reservation;
import com.example.szallasfoglalo.model.dto.ReservationDto;
import com.example.szallasfoglalo.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
@CrossOrigin(value = "*", maxAge = 0)
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/reserveAccommodation/{userId}/{accommodationId}")
    public Reservation reserveAccommodation(@PathVariable int userId, @PathVariable int accommodationId, @RequestBody ReservationDto data) {
        return this.reservationService.newReservation(userId, accommodationId, data);
    }

    @GetMapping("/getAllReservationsById/{id}")
    public List<Reservation> getAllReservationsById(@PathVariable int id) {
        return this.reservationService.getAllReservationsById(id);
    }
}
