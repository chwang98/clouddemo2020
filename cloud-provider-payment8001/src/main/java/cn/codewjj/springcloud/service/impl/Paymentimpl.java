package cn.codewjj.springcloud.service.impl;

import cn.codewjj.springcloud.mapper.PaymentMapper;
import cn.codewjj.springcloud.model.Payment;
import cn.codewjj.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: cloud2020
 * @description: PaymenetSerivce实现累
 * @author: Mr.Wang
 * @create: 2020-10-24 15:46
 **/

@Service
public class Paymentimpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment){
        return paymentMapper.create(payment);
    }
    @Override
    public Payment getPaymentById(Long id){
        return paymentMapper.getPaymentById(id);
    }

}


