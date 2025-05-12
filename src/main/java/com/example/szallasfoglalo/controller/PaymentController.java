package com.example.szallasfoglalo.controller;

import com.example.szallasfoglalo.model.Payment;
import com.example.szallasfoglalo.model.dto.PaymentDto;
import com.example.szallasfoglalo.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin(value = "*", maxAge = 0)
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registerPayment/{userId}/{currentDate}/{reservationId}")
    public Payment reserveAccommodation(@PathVariable int userId, @PathVariable String currentDate, @PathVariable String reservationId, @RequestBody PaymentDto data) {
        return this.paymentService.registerPayment(userId, currentDate, reservationId, data);
    }
}
