package com.sugelakai.order.service;

import org.springframework.stereotype.Component;

/**
 * @author kai
 * @date 2020/9/11 18:19
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String pay() {
        return "客户端降级";
    }

    @Override
    public String circuitBreaker(Integer number) {
        return "熔断后降级";
    }
}
