package com.thevarungupta.order.service.controller;

import com.thevarungupta.order.service.model.OrderRequest;
import com.thevarungupta.order.service.service.OrderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequestMapping("/api/v1/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest){
        long orderId = orderService.placeOrder(orderRequest);
        log.info("order id: {}", orderId);
        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
