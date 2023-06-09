package com.thevarungupta.payment.service.service;

import com.thevarungupta.payment.service.model.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);
}
