package com.thevarungupta.order.service.repository;

import com.thevarungupta.order.service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
