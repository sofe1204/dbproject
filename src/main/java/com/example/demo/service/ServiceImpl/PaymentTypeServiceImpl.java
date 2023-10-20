package com.example.demo.service.ServiceImpl;

import com.example.demo.model.PaymentType;
import com.example.demo.repository.PaymentTypeRepository;
import com.example.demo.service.PaymentTypeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {

    private final PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeServiceImpl(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    @Override
    public Optional<PaymentType> findById(Integer payment_type_id) {
        return this.paymentTypeRepository.findById(payment_type_id);
    }
}
