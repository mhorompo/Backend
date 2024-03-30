package com.example.szallasfoglalo.controller;

import com.example.szallasfoglalo.model.Image;
import com.example.szallasfoglalo.model.dto.ImageDto;
import com.example.szallasfoglalo.service.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/uploadImage/{id}")
    public Image uploadImage(@RequestPart("image") MultipartFile file, @PathVariable int id) throws IOException {
        return this.imageService.uploadImage(file, id);
    }

    @PutMapping("/updateImage/{id}")
    public Image updateImage(@RequestPart("image") MultipartFile file, @PathVariable int id) throws IOException {
        return this.imageService.updateImage(file, id);
    }

    @GetMapping("/getImage/{imageId}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable int imageId) {
        byte[] imageData = imageService.getImageData(imageId);
        if (imageData != null) {
            ByteArrayResource resource = new ByteArrayResource(imageData);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=image.jpg")
                    .contentType(MediaType.IMAGE_JPEG)
                    .contentLength(imageData.length)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
