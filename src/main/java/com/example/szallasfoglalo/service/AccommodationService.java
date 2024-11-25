package com.example.szallasfoglalo.service;

import com.example.szallasfoglalo.model.Accommodation;
import com.example.szallasfoglalo.model.dto.AccommodationDto;
import com.example.szallasfoglalo.repository.AccommodationRepository;
import com.example.szallasfoglalo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final UserRepository userRepository;

    public AccommodationService(AccommodationRepository accommodationRepository, UserRepository userRepository) {
        this.accommodationRepository = accommodationRepository;
        this.userRepository = userRepository;
    }

    public Accommodation addAcc(AccommodationDto accommodationDto) {
        Accommodation acc = new Accommodation();
        acc.setDescription(accommodationDto.getDescription());
        acc.setCity(accommodationDto.getCity());
        acc.setStreetName(accommodationDto.getStreetName());
        acc.setLatitude(accommodationDto.getLatitude());
        acc.setLongitude(accommodationDto.getLongitude());
        acc.setZipCode(accommodationDto.getZipCode());
        acc.setName(accommodationDto.getName());
        acc.setPrice(accommodationDto.getPrice());
        acc.setUser(userRepository.findById(accommodationDto.getUserId()).orElse(null));
        acc.setAirConditioning(accommodationDto.isAirConditioning());
        acc.setFreeParking(accommodationDto.isFreeParking());
        acc.setBarrierFree(accommodationDto.isBarrierFree());
        acc.setBreakfastIncluded(accommodationDto.isBreakfastIncluded());
        acc.setFreeWifi(accommodationDto.isFreeWifi());
        acc.setReception(accommodationDto.isReception());

        return accommodationRepository.save(acc);
    }

    public List<Accommodation> getAllAccommodations() {
        return accommodationRepository.findAll();
    }

    public Accommodation getAccommodatonById(int id) {
        return accommodationRepository.findById(id).orElse(null);
    }

    public List<Accommodation> getAccommodationsByUserId(int id) {
        return accommodationRepository.findByUserId(id);
    }

    public Accommodation updateAccommodation(AccommodationDto data, int id) {

        Accommodation acc = accommodationRepository.findById(id).orElse(null);

        if (acc == null)
            throw new NoSuchElementException("Cannot find Accommodation" + id);
        
        acc.setCity(data.getCity());
        acc.setDescription(data.getDescription());
        acc.setName(data.getName());
        acc.setLatitude(data.getLatitude());
        acc.setLongitude(data.getLongitude());
        acc.setStreetName(data.getStreetName());
        acc.setZipCode(data.getZipCode());
        acc.setPrice(data.getPrice());
        acc.setAirConditioning(data.isAirConditioning());
        acc.setFreeParking(data.isFreeParking());
        acc.setBarrierFree(data.isBarrierFree());
        acc.setBreakfastIncluded(data.isBreakfastIncluded());
        acc.setFreeWifi(data.isFreeWifi());
        acc.setReception(data.isReception());

        return accommodationRepository.save(acc);
    }

    public void deleteAccommodationById(int id) {
        // Ellenőrzés, hogy az adott ID-vel rendelkező szállás létezik-e
        if (accommodationRepository.existsById(id)) {
            accommodationRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Cannot find accommodation: " + id);
        }
    }
}
