package com.thevarungupta.order.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Instant orderDate;
    private String orderStatus;
    private Long amount;
    private ProductDetails productDetails;


    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductDetails{
        private Long productId;
        private String productName;
        private Long price;
        private Long quantity;
    }
}
