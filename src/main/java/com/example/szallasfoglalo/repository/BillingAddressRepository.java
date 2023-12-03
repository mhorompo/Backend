package com.example.szallasfoglalo.repository;

import com.example.szallasfoglalo.model.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Integer> {
}
