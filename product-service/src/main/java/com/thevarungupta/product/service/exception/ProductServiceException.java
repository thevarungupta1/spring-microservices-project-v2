package com.thevarungupta.product.service.exception;

import lombok.Data;

@Data
public class ProductServiceException extends RuntimeException{
    private String statusCode;

    public ProductServiceException(String message, String statusCode){
        super(message);
        this.statusCode = statusCode;
    }
}
