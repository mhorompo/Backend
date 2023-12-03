package com.example.szallasfoglalo.repository;

import com.example.szallasfoglalo.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageReposiroty extends JpaRepository<Image, Integer> {
}
