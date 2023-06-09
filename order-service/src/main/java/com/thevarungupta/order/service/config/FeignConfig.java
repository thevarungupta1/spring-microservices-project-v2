package com.thevarungupta.order.service.config;

import com.thevarungupta.order.service.external.decorator.CustomErrorDecoder;
import feign.codec.ErrorDecoder;
import lombok.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    ErrorDecoder errorDecoder(){
        return new CustomErrorDecoder();
    }
}
