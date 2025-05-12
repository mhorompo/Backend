package com.example.szallasfoglalo.service;

import com.example.szallasfoglalo.model.Payment;
import com.example.szallasfoglalo.model.User;
import com.example.szallasfoglalo.model.dto.PaymentDto;
import com.example.szallasfoglalo.repository.PaymentRepository;
import com.example.szallasfoglalo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UserRepository userRepository;

    public PaymentService(PaymentRepository paymentRepository, UserRepository userRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
    }

    public Payment registerPayment(int userId, String currentDate, String reservationId, PaymentDto data) {
        User user = this.userRepository.findById(userId).orElse(null);
        Payment payment = new Payment();

        payment.setUser(user);
        payment.setDate(currentDate);
        payment.setPrice(data.getPrice());
        payment.setReservationId(reservationId);
        return this.paymentRepository.save(payment);
    }
}
