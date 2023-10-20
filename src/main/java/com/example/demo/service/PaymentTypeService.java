package com.example.demo.service;

import com.example.demo.model.PaymentType;

import java.util.Optional;

public interface PaymentTypeService {
    Optional<PaymentType> findById(Integer payment_type_id);
}
