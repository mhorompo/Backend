package com.example.szallasfoglalo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "image")
@Getter
@Setter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Accommodation accommodation;
    @Lob
    @Column(name = "data", columnDefinition = "LONGBLOB")
    private byte[] data;
}
