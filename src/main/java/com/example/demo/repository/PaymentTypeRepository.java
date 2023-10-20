package com.example.demo.repository;

import com.example.demo.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {

    @Query(value="select * from Payment_Type ", nativeQuery = true)
    public Optional<PaymentType> findAllPayments();
}