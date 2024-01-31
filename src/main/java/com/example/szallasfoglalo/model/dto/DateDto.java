package com.example.szallasfoglalo.model.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DateDto {
    private LocalDate startDate;
    private LocalDate endDate;
}
