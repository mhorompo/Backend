package com.example.szallasfoglalo.controller;

import com.example.szallasfoglalo.model.Accommodation;
import com.example.szallasfoglalo.model.dto.AccommodationDto;
import com.example.szallasfoglalo.service.AccommodationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/accommodation")
@CrossOrigin(value = "*", maxAge = 0)
public class AccommodationController {
    private final AccommodationService accommodationService;


    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @PostMapping("/addAcc")
    public Accommodation addAcc(@RequestBody AccommodationDto accommodationDto) {
        return accommodationService.addAcc(accommodationDto);
    }

    @GetMapping("/getAllAccommodations")
    public List<Accommodation> getAllAccommodations() {
        return accommodationService.getAllAccommodations();
    }

    @GetMapping("/getAcc/{id}")
    public Accommodation getAcc(@PathVariable int id) {
        return accommodationService.getAccommodatonById(id);
    }

    @GetMapping("/getAllAccommodationByUserId/{id}")
    public List<Accommodation> getAccByUserId(@PathVariable int id) {
        return accommodationService.getAccommodationsByUserId(id);
    }

    @PutMapping("/updateAccommodation/{id}")
    public Accommodation updateAccommodation(@RequestBody AccommodationDto data, @PathVariable int id) {
        return accommodationService.updateAccommodation(data, id);
    }

    @DeleteMapping("/deleteAccommodation/{id}")
    public void deleteAccommodation(@PathVariable int id) {
        try {
            accommodationService.deleteAccommodationById(id);
        } catch (NoSuchElementException e) {
            System.err.println(e);
        }
    }
}