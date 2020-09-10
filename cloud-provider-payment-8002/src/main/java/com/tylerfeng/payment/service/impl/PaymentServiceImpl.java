package com.tylerfeng.payment.service.impl;

import com.tylerfeng.payment.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author kai
 * @date 2020/9/10 15:10
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void create(String id) {
        //模拟创建订单
        System.out.println(id + ":创建订单成功，流水号" + UUID.randomUUID());
    }

    @Override
    public String getById(String id) {
        return id;
    }
}
