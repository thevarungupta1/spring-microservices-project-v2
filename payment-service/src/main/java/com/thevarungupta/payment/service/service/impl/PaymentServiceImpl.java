package com.thevarungupta.payment.service.service.impl;

import com.thevarungupta.payment.service.entity.TransactionDetail;
import com.thevarungupta.payment.service.model.PaymentRequest;
import com.thevarungupta.payment.service.repository.PaymentRepository;
import com.thevarungupta.payment.service.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {
        log.info("record payment details: {}", paymentRequest);
        TransactionDetail transactionDetail = TransactionDetail.builder()
                .paymentDate(Instant.now())
                .paymentMode(paymentRequest.getPaymentMode().name())
                .paymentStatus("SUCCESS")
                .orderId(paymentRequest.getOrderId())
                .referenceNumber(paymentRequest.getReferenceNumber())
                .amount(paymentRequest.getAmount())
                .build();
        paymentRepository.save(transactionDetail);
        log.info("Transaction completed with id: {}", transactionDetail.getId());
        return transactionDetail.getId();
    }
}
