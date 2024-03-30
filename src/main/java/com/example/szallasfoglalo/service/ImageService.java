package com.example.szallasfoglalo.service;

import com.example.szallasfoglalo.model.Image;
import com.example.szallasfoglalo.model.dto.ImageDto;
import com.example.szallasfoglalo.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;
    private final AccommodationService accommodationService;

    public ImageService(ImageRepository imageRepository, AccommodationService accommodationService) {
        this.imageRepository = imageRepository;
        this.accommodationService = accommodationService;
    }

    public Image uploadImage(MultipartFile file, int id) throws IOException {
        Image img = new Image();
        img.setAccommodation(this.accommodationService.getAccommodatonById(id));
        img.setData(file.getBytes());
        return imageRepository.save(img);
    }

    public List<ImageDto> getImageById(int id) {
        Image images = imageRepository.findImageByAccommodationId(id);
        return null;
    }

    public Image updateImage(MultipartFile file, int id) throws IOException {
        Image img = imageRepository.findImageByAccommodationId(id);
        if (img == null){
            throw new NullPointerException();
        }

        img.setData(file.getBytes());
        return imageRepository.save(img);
    }

    public byte[] getImageData(int imageId) {
        Image imageEntity = imageRepository.findImageByAccommodationId(imageId);
        if (imageEntity != null) {
            return imageEntity.getData();
        }
        return null;
    }
}
