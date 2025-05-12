package com.example.szallasfoglalo.service;

import com.example.szallasfoglalo.model.Accommodation;
import com.example.szallasfoglalo.model.Reservation;
import com.example.szallasfoglalo.model.User;
import com.example.szallasfoglalo.model.dto.ReservationDto;
import com.example.szallasfoglalo.repository.AccommodationRepository;
import com.example.szallasfoglalo.repository.ReservationRepository;
import com.example.szallasfoglalo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final AccommodationRepository accommodationRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public ReservationService(AccommodationRepository accommodationRepository, ReservationRepository reservationRepository, UserRepository userRepository) {
        this.accommodationRepository = accommodationRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public Reservation newReservation(int userId, int accommodationId, ReservationDto data) {
        Accommodation accommodation = this.accommodationRepository.findById(accommodationId).orElse(null);
        User user = this.userRepository.findById(userId).orElse(null);

        Reservation reservation = new Reservation();

        reservation.setAccommodation(accommodation);
        reservation.setUser(user);
        reservation.setStartDate(data.getStartDate());
        reservation.setEndDate(data.getEndDate());
        reservation.setPrice(data.getPrice());

        return this.reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservationsById(int id) {
        return this.reservationRepository.findAllByAccommodationId(id);
    }
}
