package com.example.szallasfoglalo.repository;

import com.example.szallasfoglalo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
    Image findImageByAccommodationId(int accommodationId);
}
