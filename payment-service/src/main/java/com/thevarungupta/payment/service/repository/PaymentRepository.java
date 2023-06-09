package com.thevarungupta.payment.service.repository;

import com.thevarungupta.payment.service.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<TransactionDetail, Long> {
}
