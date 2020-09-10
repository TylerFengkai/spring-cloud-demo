package com.tylerfeng.payment.service;

/**
 * @author kai
 * @date 2020/9/10 15:09
 */
public interface PaymentService {

    /**
     * 创建订单
     *
     * @param id
     * @return void
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-10 15:09
     * @since 1.0.0
    */
    void create(String id);

    /**
     * 根据ID查询
     *
     * @param id
     * @return java.lang.String
     * @author Tyler.feng@zkteco.com
     * @throws
     * @date  2020-09-10 15:10
     * @since 1.0.0
    */
    String getById(String id);
}
