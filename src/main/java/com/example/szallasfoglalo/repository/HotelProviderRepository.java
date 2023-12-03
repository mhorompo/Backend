package com.example.szallasfoglalo.repository;

import com.example.szallasfoglalo.model.HotelProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelProviderRepository extends JpaRepository<HotelProvider, Integer> {
}
