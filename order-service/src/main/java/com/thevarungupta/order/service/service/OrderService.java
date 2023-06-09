package com.thevarungupta.order.service.service;

import com.thevarungupta.order.service.model.OrderRequest;
import com.thevarungupta.order.service.model.OrderResponse;

public interface OrderService {
    Long placeOrder(OrderRequest orderRequest);
    OrderResponse getOrderDetails(Long orderId);
}
