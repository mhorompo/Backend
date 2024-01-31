package com.example.szallasfoglalo.repository;

import com.example.szallasfoglalo.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Integer> {
    List<Accommodation> findByUserId(int id);
}
