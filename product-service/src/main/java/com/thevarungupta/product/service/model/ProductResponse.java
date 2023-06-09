package com.thevarungupta.product.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponse {
    private Long productId;
    private String productName;
    private Long price;
    private Long quantity;
}
