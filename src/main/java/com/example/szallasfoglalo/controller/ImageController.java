package com.example.szallasfoglalo.controller;

import com.example.szallasfoglalo.model.Image;
import com.example.szallasfoglalo.model.dto.ImageDto;
import com.example.szallasfoglalo.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin(value = "*", maxAge = 0)
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/uploadImage/{id}")
    public Image uploadImage(@RequestBody MultipartFile file, @PathVariable int id) throws IOException {
        return this.imageService.uploadImage(file, id);
    }

    @GetMapping("/getImagesById/{id}")
    public ResponseEntity<List<ImageDto>> getImagesByAccommodationId(@PathVariable int id) throws FileNotFoundException {
        List<ImageDto> images = imageService.getImagesById(id);

        if (!images.isEmpty()) {
            return new ResponseEntity<>(images, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
