package com.thevarungupta.order.service.service.impl;

import com.thevarungupta.order.service.entity.Order;
import com.thevarungupta.order.service.external.client.PaymentService;
import com.thevarungupta.order.service.external.client.ProductService;
import com.thevarungupta.order.service.model.OrderRequest;
import com.thevarungupta.order.service.model.OrderResponse;
import com.thevarungupta.order.service.model.PaymentRequest;
import com.thevarungupta.order.service.repository.OrderRepository;
import com.thevarungupta.order.service.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Log4j2
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private PaymentService paymentService;
    @Override
    public Long placeOrder(OrderRequest orderRequest) {
        // order entry - save the data with status order created
        // product service - block product (reduce the quantity)
        // payment service -> payment -> success -> complete, else
        // cancelled
        log.info("placing order request: {}", orderRequest);

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        Order order = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);
        log.info("order placed successfully with order Id: {}", order.getOrderId());

        log.info("calling payment service to complete the payment");
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .orderId(order.getOrderId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getTotalAmount())
                .build();

        String orderStatus = null;
        try{
            paymentService.doPayment(paymentRequest);
            log.info("payment done successfully");
            orderStatus = "PLACED";
        }catch(Exception ex){
            log.info("error occurred in payment, changing order status");
            orderStatus = "PAYMENT_FAILED";
        }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        log.info("order placed successfully with order id: "+ order.getOrderId());
        return order.getOrderId();
    }

    @Override
    public OrderResponse getOrderDetails(Long orderId) {
        return null;
    }
}
