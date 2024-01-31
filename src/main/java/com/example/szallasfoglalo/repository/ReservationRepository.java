package com.example.szallasfoglalo.repository;

import com.example.szallasfoglalo.model.Accommodation;
import com.example.szallasfoglalo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
